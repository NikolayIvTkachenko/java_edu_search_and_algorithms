package org.example.search_system_v1;

import java.util.*;
public class InvertedIndex {
    // Слово -> (URL -> количество вхождений)
     private final Map<String, Map<String, Integer>> index = new HashMap<>();
    // Добавляет документ в индекс
    public void addDocument(String url, String text) {
        String[] words = text.toLowerCase().split("\\W+");
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (word.length() < 2) continue;
            // Пропускаем слишком короткие слова
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            index.computeIfAbsent(entry.getKey(), k -> new HashMap<>())
                    .put(url, entry.getValue()); } }
    // Ищет страницы, содержащие ВСЕ слова из запроса (логическое И)
    public Set<String> search(String query) {
        String[] words = query.toLowerCase().split("\\W+");
        if (words.length == 0) return Collections.emptySet();
        Set<String> result = new HashSet<>(index.getOrDefault(words[0], Collections.emptyMap()).keySet());
        for (int i = 1; i < words.length; i++) {
            result.retainAll(index.getOrDefault(words[i], Collections.emptyMap()).keySet());
            if (result.isEmpty()) break;

        }
        return result;
    }

    public void printIndex() {
        index.forEach((word, urls) -> {
            System.out.println("Word: '" + word + "'");
            urls.forEach((url, count) -> System.out.println(" -> " + url + " (count: " + count + ")"));
        });
    }

    public int size() {
        return index.size();
    }

    public int getIndexSize() {
        return index.size();
        // В класс InvertedIndex нужно добавить: public int size() { return index.size(); }
    }
}
