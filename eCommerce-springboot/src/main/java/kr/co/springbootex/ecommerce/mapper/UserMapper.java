package kr.co.springbootex.ecommerce.mapper;

import kr.co.springbootex.ecommerce.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    User findById(Long id);
}
