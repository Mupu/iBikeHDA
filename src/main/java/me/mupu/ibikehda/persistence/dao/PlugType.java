package me.mupu.ibikehda.persistence.dao;

import lombok.*;
import me.mupu.ibikehda.persistence.dao.enums.PlugTypeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

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

    public PlugType(PlugTypeEnum type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "[PlugTypeID: " + plugTypeID
                + ", Type: " + type
                + "]";
    }
}
