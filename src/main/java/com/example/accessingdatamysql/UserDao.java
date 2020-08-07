package com.example.accessingdatamysql;

import java.util.List;
import java.util.Optional;

public interface UserDao {

//  int insertUser(User user);
  int insertUser(String username, String email, String password);
  List<User> selectAllUsers();
  Optional<User> selectUserByUserName(String username);
  Optional<User> login(User user);
}
