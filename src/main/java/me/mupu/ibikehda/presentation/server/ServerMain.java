package me.mupu.ibikehda.presentation.server;

import me.mupu.ibikehda.persistence.repository.*;
import me.mupu.ibikehda.service.StationService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

@Component
public class ServerMain {

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

    @PostConstruct
    public void start() {
        // todo your code here
    }

}
