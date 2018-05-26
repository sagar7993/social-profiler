package com.anonymous.Entity;

import javax.persistence.*;

/**
 * Created by akash.mercer on 14-05-2016.
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "mobile_number",unique = true)
    private String mobileNumber;

    @Column(name = "email", unique = true, columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin")
    private String email;


    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
