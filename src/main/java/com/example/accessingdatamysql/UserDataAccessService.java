package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mysql")
public class UserDataAccessService implements UserDao{

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public UserDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

//  @Override
//  public int insertUser(User user) {
//    final String sql = "INSERT INTO user (username, email, password) VALUES (?, ?, ?)";
//    return jdbcTemplate.update(
//      sql,
//      user.getUserName(),
//      user.getEmail(),
//      user.getPassword()
//    );
//  }

  @Override
  public int insertUser(String username, String email, String password) {
    final String sql = "INSERT INTO user (username, email, password) VALUES (?, ?, ?)";
    return jdbcTemplate.update(
      sql,
      username,
      email,
      password
    );
  }

  @Override
  public List<User> selectAllUsers() {
    final String sql = "SELECT id, username, email, password FROM user";
    return jdbcTemplate.query(
      sql,
      (resultSet,i) -> {
      return new User(
        Integer.parseInt(resultSet.getString("id")),
        resultSet.getString("username"),
        resultSet.getString("email"),
        resultSet.getString("password")
     );
    });
  }

  @Override
  public Optional<User>selectUserByUserName(String username){
    final String sql = "SELECT id, username, email, password FROM user WHERE username = ?";

    User user = jdbcTemplate.queryForObject(
      sql,
      new Object[]{username},
      (resultSet, i) -> {
        return new User(
          Integer.parseInt(resultSet.getString("id")),
          resultSet.getString("username"),
          resultSet.getString("email"),
          resultSet.getString("password")
        );
      });
    return Optional.ofNullable(user);
  }

  @Override
  public Optional<User>login(User user){
    final String sql = "SELECT id, username, email, password FROM user WHERE email = ? AND password = ? ";

    User requestUser = jdbcTemplate.queryForObject(
      sql,
      new Object[]{user.getEmail(), user.getPassword()},
      (resultSet, i) -> {
        return new User(
          Integer.parseInt(resultSet.getString("id")),
          resultSet.getString("username"),
          resultSet.getString("email"),
          resultSet.getString("password")
        );
      });
    return Optional.ofNullable(requestUser);
  }
}
