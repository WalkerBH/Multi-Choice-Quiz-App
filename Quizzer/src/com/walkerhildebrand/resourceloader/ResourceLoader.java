package com.walkerhildebrand.resourceloader;

import com.walkerhildebrand.main.Question;
import com.walkerhildebrand.main.Section;
import com.walkerhildebrand.main.Chapter;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ResourceLoader {

    public ResourceLoader() {

    }

    public Chapter[] loadData() {
        try {
            // initialize the document
            File questionFile = new File("/Files/questions.xml");
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = documentBuilder.parse(questionFile);

            if (doc.hasChildNodes()) {
                return loadChapters(doc.getChildNodes());
            } else {
                System.out.println("ResourceLoader.loadData(): Document has no child nodes");
                return null;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Chapter[] loadChapters(NodeList chapterNodes) {
        int numChapters = chapterNodes.getLength();
        Chapter[] chapters = new Chapter[numChapters];


        for (int i = 0; i < numChapters; i++) {
            chapters[i] = loadChapter(chapterNodes.item(i));
        }

        return chapters;
    }

    private Chapter loadChapter(Node node) {
        // Error Catching
        if (node.getNodeType() != Node.ELEMENT_NODE) {
            System.out.println("ResourceLoader.loadChapter(): Non-element node");
            return null;
        } if (!node.hasAttributes()) {
            System.out.println("ResourceLoader.loadChapter(): node has no attributes");
            return null;
        } if (!node.hasChildNodes()) {
            System.out.println("ResourceLoader.loadChapter(): Chapter has no child nodes");
            return null;
        }


        String name = "";
        int id = -1;

        NamedNodeMap nodeMap = node.getAttributes();

        for (int j = 0; j < nodeMap.getLength(); j++) {
            String attrName = nodeMap.item(j).getNodeName();
            String attrValue = nodeMap.item(j).getNodeValue();

            if (attrName.equals("id")) {
                id = Integer.parseInt(attrValue);
            } else if (nodeMap.item(j).getNodeName().equals("name")) {
                name = attrValue;
            } else {
                System.out.println("ResourceLoader.loadChapter(): Unexpected Attribute");
            }
        }


        // Error Catching
        if (name.equals("")) {
            System.out.println("ResourceLoader.loadChapter(): Name not defined");
            return null;
        } if (id < 0) {
            System.out.println("ResourceLoader.loadChapter(): Invalid or undefined id");
            return null;
        }


        Chapter chapter = new Chapter(id, name);
        chapter.setSections(loadSections(node.getChildNodes()));
        return chapter;
    }


    private Section[] loadSections(NodeList sectionNodes) {
        int numSections = sectionNodes.getLength();
        Section[] sections = new Section[numSections];


        for (int i = 0; i < numSections; i++) {
            sections[i] = loadSection(sectionNodes.item(i));
        }

        return sections;
    }

    private Section loadSection(Node node) {
        // Error Catching
        if (node.getNodeType() != Node.ELEMENT_NODE) {
            System.out.println("ResourceLoader.loadSection(): Non-element node");
            return null;
        } if (!node.hasAttributes()) {
            System.out.println("ResourceLoader.loadSection(): node has no attributes");
            return null;
        } if (!node.hasChildNodes()) {
            System.out.println("ResourceLoader.loadSection(): Chapter has no child nodes");
            return null;
        }


        String name = "";
        int id = -1;

        NamedNodeMap nodeMap = node.getAttributes();

        for (int j = 0; j < nodeMap.getLength(); j++) {
            String attrName = nodeMap.item(j).getNodeName();
            String attrValue = nodeMap.item(j).getNodeValue();

            if (attrName.equals("id")) {
                id = Integer.parseInt(attrValue);
            } else if (nodeMap.item(j).getNodeName().equals("name")) {
                name = attrValue;
            } else {
                System.out.println("ResourceLoader.loadSection(): Unexpected Attribute");
            }
        }


        // Error Catching
        if (name.equals("")) {
            System.out.println("ResourceLoader.loadSection(): Name not defined");
            return null;
        } if (id < 0) {
            System.out.println("ResourceLoader.loadSection(): Invalid or undefined id");
            return null;
        }


        Section section = new Section(id, name);
        section.setQuestions(loadQuestions(node.getChildNodes()));
        return section;
    }


    private Question[] loadQuestions(NodeList questionNodes) {
        int numQuestions = questionNodes.getLength();
        Question[] questions = new Question[numQuestions];

        for (int i = 0; i < numQuestions; i++) {
            questions[i] = loadQuestion(questionNodes.item(i));
        }

        return questions;
    }

    private Question loadQuestion(Node node) {
        // Error Catching
        if (node.getNodeType() != Node.ELEMENT_NODE) {
            System.out.println("ResourceLoader.loadQuestion(): Non-element node");
            return null;
        } if (!node.hasAttributes()) {
            System.out.println("ResourceLoader.loadQuestion(): node has no attributes");
            return null;
        }

        int ans = -1;

        NamedNodeMap nodeMap = node.getAttributes();

        for (int j = 0; j < nodeMap.getLength(); j++) {
            String attrName = nodeMap.item(j).getNodeName();
            String attrValue = nodeMap.item(j).getNodeValue();

            if (attrName.equals("ans")) {
                ans = Integer.parseInt(attrValue);
            } else {
                System.out.println("ResourceLoader.loadQuestion(): Unexpected Attribute");
            }
        }

        // Error Catching
        if (ans < 0 || ans > 4) {
            System.out.println("ResourceLoader.loadQuestion(): answer ["+ans+"] out of bounds/undefined");
            return null;
        }

        return new Question(node.getTextContent(), ans);


    }


}
