package me.mupu.ibikehda.presentation;

import lombok.val;
import lombok.var;
import me.mupu.ibikehda.util.HashPasswordEncoder;
import me.mupu.ibikehda.persistence.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

@Component
public class MainController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void start() {
        // todo your code here
    }

    @PostConstruct
    private void example() {
        val testPW = "test1234";
        val encoder = new HashPasswordEncoder();
        val hashedPW = encoder.encode(testPW);
        System.out.println(testPW);
        System.out.println(hashedPW);
        System.out.println(encoder.matches(testPW, hashedPW));

        var s = entityManagerFactory.createEntityManager();
        s.getTransaction().begin();
        var u = new User();
        u.setUsername("test");
        u.setEmail("test");
        u.setConfirmationToken("test");
        u.setResetPasswordToken("test");
        s.persist(u);
        s.getTransaction().commit();
    }

}
