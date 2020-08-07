package com.example.accessingdatamysql;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class User {
  private int id;
  private String username;
  private String email;
  private String password;


  public User(@JsonProperty("username") String username,
              @JsonProperty("email") String email,
              @JsonProperty("password") String password){
    this.username = username;
    this.email = email;
    this.password = password;

  }

  public User(int id, String username, String email, String password){
    this.id=id;
    this.username=username;
    this.email=email;
    this.password=password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return username;
  }

  public void setUserName(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }





}
