package com.gojgho.servicedomain.repository;

import com.gojgho.servicedomain.entity.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

  Optional<User> findByUserEmail(String userEmail);

}
