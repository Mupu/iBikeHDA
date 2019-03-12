package me.mupu.ibikehda.presentation.controller;

import lombok.val;
import lombok.var;
import me.mupu.ibikehda.persistence.dao.User;
import me.mupu.ibikehda.repository.UserRepository;
import me.mupu.ibikehda.util.HashPasswordEncoder;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import java.io.File;
import java.nio.file.Paths;
import java.util.Iterator;

import static jooqGen.Tables.*;

@Component
public class MainController {

    @Autowired
    private DSLContext context;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void start() {
        // todo your code here
//        exampleData();
        exempleXMLReader();
    }

    private void exampleData() {
        val testPW = "Bike_123";
        val encoder = new HashPasswordEncoder();
        val hashedPW = encoder.encode(testPW);
        System.out.println(testPW);
        System.out.println(hashedPW);
        System.out.println(encoder.matches(testPW, hashedPW));

        context.deleteFrom(USER).execute();

        val s = entityManagerFactory.createEntityManager();
        s.getTransaction().begin();

        var u = new User("MA1", "Bike_123", true);
        s.persist(u);
//        u = new User("MA2", "Bike_123", true);
//        s.persist(u);
//        u = new User("demo", "demo");
//        s.persist(u);

        s.getTransaction().commit();
//
        System.out.println(userRepository.findFirstByUsername("MA1").getUsername());
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
