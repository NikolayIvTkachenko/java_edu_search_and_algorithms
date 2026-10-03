package org.example.search_system_v1;
import java.util.Scanner;
import java.util.Set;

public class SearchEngine {
    private final InvertedIndex index = new InvertedIndex();

    public static void main(String[] args) {

        SearchEngine engine = new SearchEngine();
        // Настройки: стартовая страница, глубина (макс. страниц), количество потоков
        String startUrl = "https://ru.wikipedia.org/wiki/Java";
        int maxPages = 50;
        int threadCount = 4;
        System.out.println("Starting crawler...");
        Crawler crawler = new Crawler(engine.index, threadCount);
        crawler.start(startUrl, maxPages);
        System.out.println("Crawling finished. Index size: " + engine.index.getIndexSize() + " words.");

        engine.searchLoop();
    }

    private void searchLoop() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter your search query (or 'exit' to quit):");

        while (true) {
            String query = scanner.nextLine();
            if (query.equalsIgnoreCase("exit")) break;

            Set<String> results = index.search(query);
            if (results.isEmpty()) {
                System.out.println("No results found.");
            } else {
                System.out.println("Found " + results.size() + " pages:");
                results.forEach(System.out::println);
            }
            System.out.println("\nNext query:");
        }
        scanner.close();
    }


}
