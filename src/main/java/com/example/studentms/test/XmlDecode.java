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

    public static void main(String[] args) {
        match();
    }

    private static void match() {
        try{
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new File("document.xml"));

            String regex = "^\\$\\{[a-zA-Z_0-9]*\\}$";
            //获取根节点对象
            Element rootElement = document.getRootElement();
            Element bodyElement = rootElement.element("body");
            Stack<Element> matchStack = new Stack<Element>();
            Stack<Element> replaceStack = new Stack<Element>();
            StringBuilder sb = new StringBuilder();
            Iterator itr = bodyElement.elementIterator("p");
            while (itr.hasNext()) {
                Element rElement = ((Element) itr.next()).element("r");
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


            Element tableElement = bodyElement.element("tbl");
            System.out.println("table:" + tableElement);

            System.out.println("根节点名称：" + rootElement.getName());//获取节点的名称
            System.out.println("根节点有多少属性：" + rootElement.attributeCount());//获取节点属性数目
            System.out.println("根节点id属性的值：" + rootElement.attributeValue("id"));//获取节点的属性id的值
            System.out.println("根节点内文本：" + rootElement.getText());//如果元素有子节点则返回空字符串，否则返回节点内的文本
            //rootElement.getText() 之所以会换行是因为 标签与标签之间使用了tab键和换行符布局，这个也算是文本所以显示出来换行的效果。
            System.out.println("根节点内文本(1)：" + rootElement.getTextTrim());//去掉的是标签与标签之间的tab键和换行符等等，不是内容前后的空格
            System.out.println("根节点子节点文本内容：" + rootElement.getStringValue()); //返回当前节点递归所有子节点的文本信息。

            //获取子节点
            Element element = rootElement.element("module");
            if(element != null){
                System.out.println("子节点的文本：" + element.getText());//因为子节点和根节点都是Element对象所以它们的操作方式都是相同的
            }
            //但是有些情况xml比较复杂，规范不统一，某个节点不存在直接java.lang.NullPointerException，所以获取到element对象之后要先判断一下是否为空

            rootElement.setName("root");//支持修改节点名称
            System.out.println("根节点修改之后的名称：" + rootElement.getName());
            rootElement.setText("text"); //同样修改标签内的文本也一样
            System.out.println("根节点修改之后的文本：" + rootElement.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
