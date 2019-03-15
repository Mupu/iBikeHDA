package me.mupu.ibikehda.persistence.dao;

import lombok.*;
import me.mupu.ibikehda.persistence.dao.enums.BikeStatusEnum;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Bike")
public class Bike implements Serializable {
    // todo capsule bikestatus away
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BikeID")
    private long bikeID;

    @Column(name = "BikeNumber")
    private int bikeNumber;

    @Column(name = "Designation")
    private String designation;

    @Column(name = "GearCount")
    private int gearCount;

    @Column(name = "DriveTechnology")
    private String driveTechnology;

    @Column(name = "BatteryLifePercent")
    private int batteryLifePercent;

    @ManyToOne
    @JoinColumn(name = "BikeStatusID")
    private BikeStatus bikeStatus;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "MainStationID")
    private Station mainStation;

    @ManyToOne
    @JoinColumn(name = "CurrentStationID")
    private Station currentStation;

    public Bike(int bikeNumber, String designation, int gearCount, String driveTechnology,
                int batteryLifePercent, BikeStatus bikeStatus, Station mainStation,
                Station currentStation) {
        this.bikeNumber = bikeNumber;
        this.designation = designation;
        this.gearCount = gearCount;
        this.driveTechnology = driveTechnology;
        this.batteryLifePercent = batteryLifePercent;
        this.bikeStatus = bikeStatus;
        this.mainStation = mainStation;
        this.currentStation = currentStation;
    }

    public Bike(int bikeNumber, String designation, int gearCount, String driveTechnology, int batteryLifePercent, BikeStatus bikeStatus) {
        this(bikeNumber, designation, gearCount, driveTechnology, batteryLifePercent,
                bikeStatus, null, null);
    }
}