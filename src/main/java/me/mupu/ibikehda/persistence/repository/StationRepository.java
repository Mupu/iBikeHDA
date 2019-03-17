package me.mupu.ibikehda.persistence.repository;

import me.mupu.ibikehda.persistence.dao.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long>  {

    List<Station> findAllByPlace(String place);

    Station findFirstByPhoneNumber(String phoneNumber);

    Station findFirstByCoordinates(String coordinates);

}
