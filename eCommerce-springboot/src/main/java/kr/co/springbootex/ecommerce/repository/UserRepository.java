package kr.co.springbootex.ecommerce.repository;

import kr.co.springbootex.ecommerce.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    // SELECT
    public List<User> findAll(){
        String sql = "SELECT * FROM e_users";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));
    }

    // INSERT
    public int save(User user){
        String sql = "INSERT INTO e_users(name, email) VALUES (?, ?)";
        return jdbcTemplate.update(sql, user.getName(), user.getEmail());
    }

    // SELECT by ID
    public User findById(Long id){
        String sql = "SELECT * FROM e_users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ),
                id);
    }

    // UPDATE
    public int update(User user){
        String sql = "UPDATE e_users SET name = ? email = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getId());
    }

    // DELETE
    public int delete(Long id){
        String sql = "DELETE FROM u_users WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
