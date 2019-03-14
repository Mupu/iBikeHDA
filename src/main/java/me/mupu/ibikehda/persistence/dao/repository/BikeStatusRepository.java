package me.mupu.ibikehda.persistence.dao.repository;

import me.mupu.ibikehda.persistence.dao.BikeStatus;
import me.mupu.ibikehda.persistence.dao.enums.BikeStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeStatusRepository extends JpaRepository<BikeStatus, Long> {

    BikeStatus findFirstByStatusEquals(BikeStatusEnum status);

}
