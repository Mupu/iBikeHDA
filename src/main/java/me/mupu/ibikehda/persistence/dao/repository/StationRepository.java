package me.mupu.ibikehda.persistence.dao.repository;

import me.mupu.ibikehda.persistence.dao.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
public interface StationRepository extends JpaRepository<Station, Long>  {

    Set<Station> findAllByPlace(String place);

    Station findFirstByPhoneNumber(String phoneNumber);

    Station findFirstByCoordinates(String coordinates);

}
