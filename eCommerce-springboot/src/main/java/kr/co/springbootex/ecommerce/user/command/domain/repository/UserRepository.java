package kr.co.springbootex.ecommerce.user.command.domain.repository;

import kr.co.springbootex.ecommerce.user.command.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    // 이메일 중복 체크
    boolean existsByNmEmail(String nmEmail);
}