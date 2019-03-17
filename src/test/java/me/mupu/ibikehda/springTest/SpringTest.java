package me.mupu.ibikehda.springTest;

import lombok.val;
import lombok.var;
import me.mupu.ibikehda.persistence.dao.*;
import me.mupu.ibikehda.persistence.dao.enums.BikeStatusEnum;
import me.mupu.ibikehda.persistence.dao.enums.PlugTypeEnum;
import me.mupu.ibikehda.persistence.dao.enums.TerminalTypeEnum;
import me.mupu.ibikehda.persistence.repository.*;
import me.mupu.ibikehda.server_client_commonication.DataPackageLikeBikeListExample;
import me.mupu.ibikehda.service.StationService;
import me.mupu.ibikehda.util.HashPasswordEncoder;
import org.jooq.DSLContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;

import java.util.ArrayList;

@Commit
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void t00_deleteAll() {
        terminalTypeRepository.deleteAll();
        stationRepository.deleteAll();
        plugTypeRepository.deleteAll();
        bikeStatusRepository.deleteAll();
        bikeRepository.deleteAll();
        userRepository.deleteAll();
    }


    @Test
    public void t01_terminalRepo() {
        terminalTypeRepository.save(new TerminalType(TerminalTypeEnum.PIN));
        terminalTypeRepository.save(new TerminalType(TerminalTypeEnum.APP));

        System.out.println(terminalTypeRepository.findFirstByTypeEquals(TerminalTypeEnum.APP));
        System.out.println(terminalTypeRepository.findFirstByTypeEquals(TerminalTypeEnum.PIN));
        System.out.println(terminalTypeRepository.findAll());
        System.out.println();
    }

    @Test
    public void t02_stationRepo() {

        var s = new Station("456", "hda14", "günnistraße", "4a",
                "456'789", terminalTypeRepository.save(new TerminalType(TerminalTypeEnum.MAP)));
        stationRepository.save(s);

        var hs = new ArrayList<PlugType>();
        hs.add(plugTypeRepository.save(new PlugType(PlugTypeEnum.MODE1)));
        s.setPlugs(hs);
        stationRepository.save(s);

        System.out.println("place\n" + stationRepository.findAllByPlace("hda14"));
        System.out.println("coords\n" + stationRepository.findFirstByCoordinates("456'789"));
        System.out.println("phone\n" + stationRepository.findFirstByPhoneNumber("456"));
        System.out.println(stationRepository.findAll());
    }

    @Test
    public void t03_plugTypeRepo() {

        plugTypeRepository.save(new PlugType(PlugTypeEnum.MODE2));

        System.out.println(plugTypeRepository.findFirstByTypeEquals(PlugTypeEnum.MODE2));
        System.out.println(plugTypeRepository.findAll());

    }

    @Test
    public void t04_bikeStatusRepo() {

        bikeStatusRepository.save(new BikeStatus(BikeStatusEnum.RENTED));

        System.out.println(bikeStatusRepository.findFirstByStatusEquals(BikeStatusEnum.RENTED));
        System.out.println(bikeStatusRepository.findAll());

    }

    @Test
    public void t05_bikeRepo() {

        var s = stationRepository.findAllByPlace("hda14").get(0);
        var b = new Bike(1802, "geil", 9, "supper speedo motor",
                100, bikeStatusRepository.save(new BikeStatus(BikeStatusEnum.DEFECT)),
                s, s);
        bikeRepository.save(b);

        var bs = bikeStatusRepository.findFirstByStatusEquals(BikeStatusEnum.DEFECT);


        var u = new User("biku", new HashPasswordEncoder().encode("biku"));
        u = userRepository.save(u);

        System.out.println("main\n" + bikeRepository.findAllByMainStationEquals(s));
        System.out.println("cur\n" + bikeRepository.findAllByCurrentStationEquals(s));
        System.out.println("blpgte\n" + bikeRepository.findAllByBatteryLifePercentGreaterThanEqual(100));
        System.out.println("blplte\n" + bikeRepository.findAllByBatteryLifePercentLessThanEqual(100));
        System.out.println("num\n" + bikeRepository.findAllByBikeNumber(1802));
        System.out.println("state\n" + bikeRepository.findAllByBikeStatus(bs));
        System.out.println("desig\n" + bikeRepository.findAllByDesignationIsLike("geil"));
        System.out.println("techno\n" + bikeRepository.findAllByDriveTechnologyIsLike("%spe%"));
        System.out.println("gce\n" + bikeRepository.findAllByGearCountEquals(9));
        System.out.println("gcgte\n" + bikeRepository.findAllByGearCountGreaterThanEqual(9));
        System.out.println("gclte\n" + bikeRepository.findAllByGearCountLessThanEqual(9));
        System.out.println("ce\n" + bikeRepository.findAllByCustomerEquals(u));
        System.out.println("all\n" + bikeRepository.findAll());
        System.out.println("###########");
        System.out.println(s.getBikes());
        s = stationRepository.findAllByPlace("hda14").get(0);
        System.out.println(s.getBikes());

    }

    @Test
    public void t06_userRepo() {
        val encoder = new HashPasswordEncoder();
        val hashedPw = encoder.encode("demo");

        var u = new User("MA1", encoder.encode("Bike_123"), true);

        userRepository.save(u);
        u = new User("MA2", encoder.encode("Bike_123"), true);
        userRepository.save(u);
        u = new User("demo", encoder.encode(hashedPw));
        userRepository.save(u);

        var b = bikeRepository.findAll().get(0);

        var s = stationRepository.findFirstByPhoneNumber("456");

        b.setMainStation(s);
        b.setCurrentStation(s);
        bikeRepository.save(b);

        System.out.println(encoder.matches("Bike_123",
                userRepository.findFirstByUsername("MA1").getPassword()));
        System.out.println(encoder.matches("Bike_123",
                userRepository.findFirstByUsername("MA2").getPassword()));
        System.out.println(encoder.matches(hashedPw,
                userRepository.findFirstByUsername("demo").getPassword()));

        b.setCustomer(u);
        bikeRepository.save(b);

        u = userRepository.findFirstByUsername("demo");
        System.out.println(u);
        System.out.println("bikes: " + bikeRepository.findAllByCustomerEquals(u));

        System.out.println(userRepository.findAll());
    }


}
