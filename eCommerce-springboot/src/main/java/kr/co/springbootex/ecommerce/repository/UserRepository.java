package kr.co.springbootex.ecommerce.repository;

import kr.co.springbootex.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.name=:name AND u.email=:email")
    List<User> findByNameAndAge(@Param("name") String name, @Param("email") String email);

}
