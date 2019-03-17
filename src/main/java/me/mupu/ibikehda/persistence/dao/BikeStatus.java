package me.mupu.ibikehda.persistence.dao;

import lombok.*;
import me.mupu.ibikehda.persistence.dao.enums.BikeStatusEnum;
import me.mupu.ibikehda.persistence.dao.enums.PlugTypeEnum;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BikeStatus")
public class BikeStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BikeStatusID")
    private long bikeStatusID;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private BikeStatusEnum status;

    public BikeStatus(BikeStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[BikeStatusID: " + bikeStatusID
                + ", Status: " + status
                + "]";
    }
}