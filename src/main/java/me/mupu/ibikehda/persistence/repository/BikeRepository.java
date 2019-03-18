package me.mupu.ibikehda.persistence.repository;

import me.mupu.ibikehda.persistence.dao.Bike;
import me.mupu.ibikehda.persistence.dao.BikeStatus;
import me.mupu.ibikehda.persistence.dao.Station;
import me.mupu.ibikehda.persistence.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long>  {

    List<Bike> findAllByBikeNumber(int number);

    List<Bike> findAllByDesignationIsLike(String designation);

    List<Bike> findAllByGearCountEquals(int gearCount);
    List<Bike> findAllByGearCountGreaterThanEqual(int minGearCount);
    List<Bike> findAllByGearCountLessThanEqual(int maxGearCount);

    List<Bike> findAllByDriveTechnologyIsLike(String driveTechnology);

    List<Bike> findAllByBatteryLifePercentGreaterThanEqual(int minPercent);
    List<Bike> findAllByBatteryLifePercentLessThanEqual(int maxPercent);

    List<Bike> findAllByMainStationEquals(Station mainStation);

    List<Bike> findAllByCurrentStationEquals(Station mainStation);

    List<Bike> findAllByBikeStatus(BikeStatus status);

    List<Bike> findAllByCustomerEquals(User customer);

}
