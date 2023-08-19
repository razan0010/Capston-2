package com.example.educationalplatform.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name should be not null")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message = "Email must be not null")
    @Email(message = "Email must be a valid")
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email;

    @NotNull(message = "Password should be not null")
    @Pattern(regexp ="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d\\s]{1,}$" , message = "Password have characters and digits")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotNull(message = "Courses should be not null")
    @Column(columnDefinition = "varchar(60) not null")
    private String courses;

    @NotNull(message = "Salary should be not null")
    @PositiveOrZero(message =  "salary should be positive")
    @Column(columnDefinition = "double not null")
    private Double salary;


    @Column(columnDefinition =" boolean default false")
    private boolean annualLeave = false;

}
