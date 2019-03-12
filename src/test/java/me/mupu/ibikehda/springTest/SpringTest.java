package me.mupu.ibikehda.springTest;

import lombok.val;
import lombok.var;
import me.mupu.ibikehda.persistence.dao.User;
import me.mupu.ibikehda.repository.UserRepository;
import me.mupu.ibikehda.util.HashPasswordEncoder;
import org.jooq.DSLContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;

import static jooqGen.Tables.USER;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {

    @Autowired
    private DSLContext context;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void disablejooqbanner() {
        System.getProperties().setProperty("org.jooq.no-logo", "true");
    }

    @Test
    public void test() {
        System.out.println(context);
        exampleData();
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

}
