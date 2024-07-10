package com.litovchenko.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String name;

    //Constructors
    public User (int id, String username, String password, String email, String name){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public User (String username, String password, String email, String name){
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    //getters and setters
    //Id
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    //Username
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    //Password
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    //Email
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    //Name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id= " + id + ", username= " + username + ", password= " + password + ", email= " + email + ", name= " + name + "]";
    }
}
