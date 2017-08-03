package com.example.studentms.test;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;

public class XmlDecode {
    static String regex = "^\\$\\{[a-zA-Z_0-9]*\\}$";

    public static void main(String[] args) {
        match();
    }

    private static void match() {

        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new File("document.xml"));
            Element rootElement = document.getRootElement();
            Element bodyElement = rootElement.element("body");
            replaceP(bodyElement);
            replaceTbl(bodyElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void replaceP(Element bodyElement) {
        Stack<Element> matchStack = new Stack<Element>();
        Stack<Element> replaceStack = new Stack<Element>();
        StringBuilder sb = new StringBuilder();
        Iterator pItr = bodyElement.elementIterator("p");
        while (pItr.hasNext()) {
            Element pElement = (Element) pItr.next();
            Iterator rItr = pElement.elementIterator("r");
            while (rItr.hasNext()) {
                Element rElement = (Element) rItr.next();
                if (rElement == null) {
                    continue;
                }
                Element textElement = rElement.element("t");
                if (textElement == null) {
                    continue;
                }
                System.out.println("text:" + textElement.getText());
                String text = textElement.getText();
                if (text.matches(regex)) {
                    textElement.setText("找到了！！！！！！！！！！！");
                } else if ("${".equals(text)) {
                    replaceStack.clear();
                    matchStack.push(textElement);
                } else if ("}".equals(text)) {
                    while (!matchStack.empty()) {
                        Element element = matchStack.pop();
                        if (!"${".equals(element.getText())) {
                            replaceStack.push(element);
                        }
                    }
                    while (!replaceStack.isEmpty()) {
                        Element element = replaceStack.pop();
                        sb.append(element.getText());
                        bodyElement.remove(element.getParent().getParent());
                    }
                    textElement.setText("找到了！！！！！！！！！！！");
                    bodyElement.add(textElement.getParent().getParent());
                } else if (!matchStack.empty()) {
                    matchStack.push(textElement);
                }
            }
        }
    }

    private static void replaceTbl(Element bodyElement) {
        Stack<Element> matchStack = new Stack<Element>();
        Stack<Element> replaceStack = new Stack<Element>();
        StringBuilder sb = new StringBuilder();
        Iterator tblItr = bodyElement.elementIterator("tbl");
        while (tblItr.hasNext()) {
            Element tblElement = (Element) tblItr.next();
            Iterator trItr = tblElement.elementIterator("tr");
            while (trItr.hasNext()) {
                Element trElement = (Element) trItr.next();
                Iterator tcItr = trElement.elementIterator("tc");
                while (tcItr.hasNext()) {
                    Element tcElement = (Element) tcItr.next();
                    Iterator pItr = tcElement.elementIterator("p");
                    while (pItr.hasNext()) {
                        Element pElement = (Element) pItr.next();
                        Iterator rItr = pElement.elementIterator("r");

                        while (rItr.hasNext()) {
                            Element rElement = (Element) rItr.next();
                            if (rElement == null) {
                                continue;
                            }
                            Element textElement = rElement.element("t");
                            if (textElement == null) {
                                continue;
                            }
                            System.out.println("text:" + textElement.getText());
                            String text = textElement.getText();
                            if (text.matches(regex)) {
                                textElement.setText("找到了！！！！！！！！！！！");
                            } else if ("${".equals(text)) {
                                replaceStack.clear();
                                matchStack.push(textElement);
                            } else if ("}".equals(text)) {
                                while (!matchStack.empty()) {
                                    Element element = matchStack.pop();
                                    if (!"${".equals(element.getText())) {
                                        replaceStack.push(element);
                                    }
                                }
                                while (!replaceStack.isEmpty()) {
                                    Element element = replaceStack.pop();
                                    sb.append(element.getText());
                                    bodyElement.remove(element.getParent().getParent());
                                }
                                textElement.setText("找到了！！！！！！！！！！！");
                                bodyElement.add(textElement.getParent().getParent());
                            } else if (!matchStack.empty()) {
                                matchStack.push(textElement);
                            }
                        }
                    }
                }
            }

        }
    }
}
