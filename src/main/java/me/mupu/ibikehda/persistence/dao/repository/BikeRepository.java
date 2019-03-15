package me.mupu.ibikehda.persistence.dao.repository;

import me.mupu.ibikehda.persistence.dao.Bike;
import me.mupu.ibikehda.persistence.dao.BikeStatus;
import me.mupu.ibikehda.persistence.dao.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long>  {

    Set<Bike> findAllByBikeNumber(int minPercent);

    Set<Bike> findAllByDesignationIsLike(String designation);

    Set<Bike> findAllByGearCountEquals(int gearCount);
    Set<Bike> findAllByGearCountGreaterThanEqual(int minGearCount);
    Set<Bike> findAllByGearCountLessThanEqual(int maxGearCount);

    Set<Bike> findAllByDriveTechnologyIsLike(String driveTechnology);

    Set<Bike> findAllByBatteryLifePercentGreaterThanEqual(int minPercent);
    Set<Bike> findAllByBatteryLifePercentLessThanEqual(int maxPercent);

    Set<Bike> findAllByMainStationEquals(Station mainStation);

    Set<Bike> findAllByCurrentStationEquals(Station mainStation);

    Set<Bike> findAllByBikeStatus(BikeStatus status);

}
