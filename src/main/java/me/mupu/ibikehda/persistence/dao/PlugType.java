package me.mupu.ibikehda.persistence.dao;

import lombok.*;
import me.mupu.ibikehda.persistence.dao.enums.PlugTypeEnum;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PlugType")
public class PlugType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PlugTypeID")
    private long plugTypeID;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type")
    private PlugTypeEnum type;

}
