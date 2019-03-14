package me.mupu.ibikehda.persistence.dao.repository;

import me.mupu.ibikehda.persistence.dao.PlugType;
import me.mupu.ibikehda.persistence.dao.enums.PlugTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlugTypeRepository extends JpaRepository<PlugType, Long> {

    PlugType findFirstByTypeEquals(PlugTypeEnum type);

}
