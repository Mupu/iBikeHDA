package me.mupu.ibikehda.persistence.dao;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Station")
public class Station implements Serializable {
    // todo capsule plugtype and terminaltype away
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
    @JoinColumn(name = "TerminalTypeID")
    private TerminalType terminalType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Station_PlugType",
            joinColumns = { @JoinColumn(name = "StationID") },
            inverseJoinColumns = { @JoinColumn(name = "PlugTypeID") }
    )
    private Set<PlugType> plugs;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "mainStation")
//    @JoinColumn(name = "MainStationID")
//    private Set<Bike> bikes;

    public Station(String phoneNumber, String place, String street, String houseNumber, String coordinates, TerminalType terminalType) {
        this.phoneNumber = phoneNumber;
        this.place = place;
        this.street = street;
        this.houseNumber = houseNumber;
        this.coordinates = coordinates;
        this.terminalType = terminalType;
    }
}
