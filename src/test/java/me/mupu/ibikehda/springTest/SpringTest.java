package me.mupu.ibikehda.springTest;

import lombok.val;
import lombok.var;
import me.mupu.ibikehda.persistence.dao.*;
import me.mupu.ibikehda.persistence.dao.enums.BikeStatusEnum;
import me.mupu.ibikehda.persistence.dao.enums.PlugTypeEnum;
import me.mupu.ibikehda.persistence.dao.enums.TerminalTypeEnum;
import me.mupu.ibikehda.persistence.dao.repository.*;
import me.mupu.ibikehda.service.StationService;
import me.mupu.ibikehda.util.HashPasswordEncoder;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.jooq.DSLContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;

import java.util.HashSet;

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

    @Autowired
    private PlugTypeRepository plugTypeRepository;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private BikeStatusRepository bikeStatusRepository;

    @Autowired
    private TerminalTypeRepository terminalTypeRepository;

    @Autowired
    private StationService stationService;

    @Before
    public void disablejooqbanner() {
        System.getProperties().setProperty("org.jooq.no-logo", "true");
    }

    @Test
    public void test() {

    }

    @Test
    @Transactional
    public void exampleData() {
        val encoder = new HashPasswordEncoder();
        val hashedPw = encoder.encode("demo");
        userRepository.deleteAll();
        bikeStatusRepository.deleteAll();
        bikeRepository.deleteAll();
        terminalTypeRepository.deleteAll();
        plugTypeRepository.deleteAll();
        stationRepository.deleteAll();

        var u = new User("MA1", encoder.encode("Bike_123"), true);
        userRepository.save(u);
        u = new User("MA2", encoder.encode("Bike_123"), true);
        userRepository.save(u);
        u = new User("demo", encoder.encode(hashedPw));
        userRepository.save(u);

        var b = new Bike(1802, "geil", 9, "supper speedo motor", 100,
                bikeStatusRepository.save(new BikeStatus(BikeStatusEnum.DEFECT)));
        bikeRepository.save(b);

        var s = new Station("456", "hda14", "günnistraße", "4a",
                "456'789", terminalTypeRepository.save(new TerminalType(TerminalTypeEnum.MAP)));
        stationRepository.save(s);

        var hs = new HashSet<PlugType>();
        hs.add(plugTypeRepository.save(new PlugType(PlugTypeEnum.MODE1)));
        hs.add(plugTypeRepository.save(new PlugType(PlugTypeEnum.MODE2)));
        s.setPlugs(hs);
        stationRepository.save(s);

        b.setMainStation(s);
        b.setCurrentStation(s);
        bikeRepository.save(b);

        System.out.println(encoder.matches("Bike_123",
                userRepository.findFirstByUsername("MA1").getPassword()));
        System.out.println(encoder.matches("Bike_123",
                userRepository.findFirstByUsername("MA2").getPassword()));
        System.out.println(encoder.matches(hashedPw,
                userRepository.findFirstByUsername("demo").getPassword()));

        System.out.println(userRepository.findAll());

        System.out.println(terminalTypeRepository.findAll());

        System.out.println(bikeRepository.findAll());

        System.out.println(bikeStatusRepository.findAll());


        System.out.println(plugTypeRepository.findAll());

        System.out.println(bikeStatusRepository.findFirstByStatusEquals(BikeStatusEnum.DEFECT));
        System.out.println(plugTypeRepository.findFirstByTypeEquals(PlugTypeEnum.MODE1));
        System.out.println(terminalTypeRepository.findFirstByTypeEquals(TerminalTypeEnum.MAP));

    }

}
