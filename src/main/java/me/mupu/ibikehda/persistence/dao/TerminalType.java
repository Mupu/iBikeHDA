package me.mupu.ibikehda.persistence.dao;

import lombok.*;
import me.mupu.ibikehda.persistence.dao.enums.TerminalTypeEnum;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TerminalType")
public class TerminalType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TerminalTypeID")
    private long terminalTypeID;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type")
    private TerminalTypeEnum type;

}