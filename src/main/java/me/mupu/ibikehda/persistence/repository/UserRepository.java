package me.mupu.ibikehda.persistence.repository;

import me.mupu.ibikehda.persistence.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByUsername(String username);

    @Query("SELECT u FROM User u")
    List<User> findallusers();

}
