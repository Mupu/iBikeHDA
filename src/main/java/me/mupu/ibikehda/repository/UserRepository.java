package me.mupu.ibikehda.repository;

import me.mupu.ibikehda.persistence.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // todo implement

    User findFirstByUsername(String username);

}
