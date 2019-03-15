package me.mupu.ibikehda.persistence.dao;

import lombok.*;
import me.mupu.ibikehda.persistence.dao.enums.PlugTypeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PlugType")
public class PlugType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PlugTypeID")
    private long plugTypeID;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type")
    private PlugTypeEnum type;

    @ManyToMany(mappedBy = "plugs")
    private Set<Station> stations;

    public PlugType(PlugTypeEnum type) {
        this.type = type;
    }


}
