package me.mupu.ibikehda.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.mupu.ibikehda.persistence.dao.enums.BikeStatusEnum;
import me.mupu.ibikehda.persistence.dao.enums.PlugTypeEnum;

import javax.persistence.*;
import java.io.Serializable;

@Data
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
}