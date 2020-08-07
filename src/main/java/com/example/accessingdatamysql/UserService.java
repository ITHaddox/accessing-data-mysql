package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  private final UserDataAccessService userDataAccessService;

  @Autowired
  public UserService(@Qualifier("mysql") UserDataAccessService userDataAccessService){
    this.userDataAccessService = userDataAccessService;
  }


//  public int addUser(User user){
//    return userDataAccessService.insertUser(user);
//  }
  public int addUser(String username, String email, String password){
    return userDataAccessService.insertUser(username,email,password);
  }

  public List<User> getAllUsers(){
    return userDataAccessService.selectAllUsers();
  }

  public Optional<User> getUserByUserName(String username) {
    return userDataAccessService.selectUserByUserName(username);
  }

  public Optional<User> loginUser(User user) {
    return userDataAccessService.login(user);
  }
}
