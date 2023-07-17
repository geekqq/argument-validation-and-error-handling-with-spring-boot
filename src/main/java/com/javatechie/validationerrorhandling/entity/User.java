package com.javatechie.validationerrorhandling.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
@Builder
@Table(name = "USERTABLE")
public class User {

    @Id
    @GeneratedValue
    private int userId;
    private String name;
    private String email;
    private String mobile;
    private Gender gender;
    private int age;
    private String nationality;

}
