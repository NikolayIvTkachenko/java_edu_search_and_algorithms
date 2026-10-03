package org.example.source_code_v0;

import java.io.IOException;
import java.util.*;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class WikiFetcherApp {
    final static List<String> visited = new ArrayList<String>();
    final static WikiFetcher wf = new WikiFetcher();

    final static List<String> urlList = new ArrayList<String>();

    /**
     * Tests a conjecture about Wikipedia and Philosophy.
     *
     * https://en.wikipedia.org/wiki/Wikipedia:Getting_to_Philosophy
     *
     * 1. Clicking on the first non-parenthesized, non-italicized link
     * 2. Ignoring external links, links to the current page, or red links
     * 3. Stopping when reaching "Philosophy", a page with no links or a page
     *    that does not exist, or when a loop occurs
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String destination = "https://en.wikipedia.org/wiki/Philosophy";
        String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        // testConjecture(destination, source, 10);

        WikiFetcher wf = new WikiFetcher();
        urlList.add(destination);
        urlList.add(source);

        for (String url: urlList) {
            Elements paragraphs = wf.fetchWikipedia(url);
            processParagraphs(paragraphs); // - метод который выполняет действия с объектом Elements
        }
    }

    private static void  processParagraphs(Elements paragraphs) {

        System.out.print(paragraphs.size());

        for (Element item : paragraphs) {

            Element firstPara = item;

            recursiveDFS(firstPara);
            System.out.println();

            iterativeDFS(firstPara);
            System.out.println();

            Iterable<Node> iter = new WikiNodeIterable(firstPara);
            for (Node node: iter) {
                if (node instanceof TextNode) {
                    System.out.print(node);
                }
            }

        }
    }

    /**
     * Starts from given URL and follows first link until it finds the destination or exceeds the limit.
     *
     * @param destination
     * @param source
     * @throws IOException
     */
    public static void testConjecture(String destination, String source, int limit) throws IOException {
        // TODO: FILL THIS IN!
    }

    private static void iterativeDFS(Node root) {
        Deque<Node> stack = new ArrayDeque<Node>();
        stack.push(root);

        // if the stack is empty, we're done
        while (!stack.isEmpty()) {

            // otherwise pop the next Node off the stack
            Node node = stack.pop();
            if (node instanceof TextNode) {
                System.out.print(node);
            }

            // push the children onto the stack in reverse order
            List<Node> nodes = new ArrayList<Node>(node.childNodes());
            Collections.reverse(nodes);

            for (Node child: nodes) {
                stack.push(child);
            }
        }
    }

    private static void recursiveDFS(Node node) {
        if (node instanceof TextNode) {
            System.out.print(node);
        }
        for (Node child: node.childNodes()) {
            recursiveDFS(child);
        }
    }
}
