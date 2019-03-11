package me.mupu.ibikehda.persistence.dao;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
abstract class BaseEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

}
