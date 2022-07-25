package com.beanos.backend.models;

import javax.persistence.*;
 
@Entity
@Table(name = "users")
    public class User {
    public User() {}
    public User(Integer _id, String mail, String pass) {
        id = _id;
        email = mail;
        password = pass;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Column(name = "email", nullable = false, unique = true, length = 45)
    private String email;
     
    @Column(nullable = false, length = 64)
    private String password;
     
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
