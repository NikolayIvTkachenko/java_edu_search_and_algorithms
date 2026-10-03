package org.example.search_system_v1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Crawler {
    private final Set<String> visitedUrls = ConcurrentHashMap.newKeySet();
    private final BlockingQueue<String> urlQueue = new LinkedBlockingQueue<>();
    private final InvertedIndex index;
    private final ExecutorService executor;


    public Crawler(InvertedIndex index, int threadCount) {
        this.index = index;
        this.executor = Executors.newFixedThreadPool(threadCount);
    }

    public void start(String startUrl, int maxPages) {
        urlQueue.offer(startUrl);
        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < maxPages; i++) {
            final String url = urlQueue.poll();
            if (url == null || visitedUrls.contains(url)) continue;
            visitedUrls.add(url);
            futures.add(executor.submit(() -> processPage(url, maxPages)));
        }
        // Дожидаемся завершения задач
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException ignored) {}
        }
        executor.shutdown();
    }

    private void processPage(String url, int maxPages) {
        try {
            System.out.println("Crawling: " + url);
            Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
            // 1. Извлекаем текст и отдаем индексатору
            String text = doc.body().text();
            index.addDocument(url, text);

            // 2. Находим новые ссылки
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                String nextUrl = link.absUrl("href");
                if (nextUrl.isEmpty() || !nextUrl.startsWith("http")) continue;
                if (visitedUrls.size() >= maxPages) continue;
                urlQueue.offer(nextUrl);
            }

        } catch (IOException e) {
            System.err.println("Failed to fetch: " + url);
        }

    }

}
