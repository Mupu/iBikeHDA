package me.mupu.ibikehda.presentation.server;

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
public class ServerMain {

    @Autowired
    private DSLContext context;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void start() {
        // todo your code here
    }

}
