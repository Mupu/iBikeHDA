package me.mupu.ibikehda.persistence.dao.repository;

import me.mupu.ibikehda.persistence.dao.TerminalType;
import me.mupu.ibikehda.persistence.dao.enums.TerminalTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalTypeRepository extends JpaRepository<TerminalType, Long> {

    TerminalType findFirstByTypeEquals(TerminalTypeEnum type);

}
