package com.dily.services;
import com.dily.mappers.UserMapper;
import com.dily.entities.User;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Andra on 5/7/2017.
 */
@Service
public class AuthServiceImpl implements AuthService{

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql="select * from user_table u where u.username=? and u.password=?";

        jdbcTemplate = new JdbcTemplate(dataSource);
        User user = (User)jdbcTemplate.queryForObject(
                sql, new Object[] { username,password }, new UserMapper());
        return user;

    }
}
