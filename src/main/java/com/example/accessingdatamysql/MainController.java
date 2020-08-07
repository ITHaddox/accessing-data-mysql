package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping(path="/demo")
@RestController
public class MainController {

  private final UserService userService;

  @Autowired
  public MainController(UserService userService){
    this.userService = userService;
  }

//  @PostMapping(path = "/add")
//  public void addPerson(@NonNull @RequestBody User user){
//    userService.addUser(user);
//  }

  @PostMapping(path = "/add")
  public void addPerson(@NonNull @RequestBody String username,
                        @NonNull @RequestBody String email,
                        @NonNull @RequestBody String password){
    userService.addUser(username, email, password);
  }


  @GetMapping(path = "/all")
  public List<User> getAllUsers(){
    return userService.getAllUsers();
  }

  @GetMapping(path = "/username")
  public Optional<User> getUserByUserName(@NonNull @RequestBody String username){
    return userService.getUserByUserName(username);
  }

    @PostMapping(path = "/login")
    public Optional<User> loginUser(@NonNull @RequestBody User user){
      return userService.loginUser(user);
  }
}
