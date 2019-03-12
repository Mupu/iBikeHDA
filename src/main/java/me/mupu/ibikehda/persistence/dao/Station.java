package me.mupu.ibikehda.persistence.dao;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Station")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StationID")
    private long stationID;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Place")
    private String place;

    @Column(name = "Street")
    private String street;

    @Column(name = "HouseNumber")
    private String houseNumber;

    @Column(name = "Coordinates")
    private String coordinates;

    @ManyToOne()
    private TerminalType terminalType;

}
