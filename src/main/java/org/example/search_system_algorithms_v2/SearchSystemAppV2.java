package org.example.search_system_algorithms_v2;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;


public class SearchSystemAppV2 {

    static void main() throws IOException {
        program();
    }


    static void program() throws IOException {
        String url = "http://en.wikipedia.org/wiki/Java_(programming_language)";
        Connection connect = Jsoup.connect(url);
        Document doc = connect.get();

        Element content = doc.getElementById("mw-content-text");
        assert content != null;
        Elements paragraphs = content.select("p");

        System.out.println(paragraphs);

        Element firstPara = paragraphs.get(0);

//        Iterable<Node> iter = new WikiNodeIterable(firstPara);
//        for(Node node: iter) {
//            if (node instanceof TextNode) {
//                System.out.print(node);
//            }
//        }

    }


//    private static void recursiveDFS(Node node) {
//        if (node instanceof TextNode) {
//            System.out.println(node);
//        }
//        for (Node child: node.childModes()) {
//            recursiveDFS(child);
//        }
//    }


//    private static void iterativeDFS(Node root) {
//        Deque<Node> stack = new ArrayDeque<>();
//        stack.push(root);
//
//        while(!stack.isEmpty()) {
//            Node node = stack.pop();
//            if(node instanceof TextNode) {
//                System.out.print(node);
//            }
//
//            List<Node> nodes = new ArrayList<>(node.childNodes);
//            Collections.reverse(nodes);
//
//            for(Node child: nodes) {
//                stack.push(child);
//            }
//        }
//    }

}
