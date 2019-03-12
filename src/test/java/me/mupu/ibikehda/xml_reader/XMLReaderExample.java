package me.mupu.ibikehda.xml_reader;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.nio.file.Paths;

public class XMLReaderExample {

    public static void main(String[] args) {
        new XMLReaderExample();
    }

    public XMLReaderExample() {
        exempleXMLReader();
    }

    private void exempleXMLReader() {
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(Paths.get(getClass().getClassLoader().getResource("ebike.xml").toURI()).toFile());

            // ebikeliste
            Element rootElement = document.getRootElement();

            rootElement.elementIterator().forEachRemaining(e -> {
                System.out.println(e.getName());
                e.attributeIterator().forEachRemaining(a -> System.out.println(a.getData()));
                System.out.println(e.getText());
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
