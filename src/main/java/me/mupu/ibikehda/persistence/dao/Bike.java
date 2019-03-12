package me.mupu.ibikehda.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.mupu.ibikehda.persistence.dao.enums.BikeStatusEnum;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Bike")
public class Bike {

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
    private int driveTechnology;

    @Column(name = "BatteryLifePercent")
    private int batteryLifePercent;

    @ManyToOne
    private BikeStatus bikeStatusID;

    @ManyToOne
    private Station mainStationID;

    @ManyToOne
    private Station currentStationID;

}