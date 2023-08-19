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
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name should be not null")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message = "Major should be not null")
    @Column(columnDefinition = "varchar(50) not null")
    private String major;

    @NotNull(message = "Email must be not null")
    @Email(message = "Email must be a valid")
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email;

    @NotNull(message = "Password should be not null")
    @Pattern(regexp ="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d\\s]{1,}$" , message = "Password have characters and digits")
    @Column(columnDefinition = "varchar(50) not null")
    private String password;

    @NotNull(message = "Number of Courses should be not null")
    @PositiveOrZero(message =  "Number of Courses should be positive")
    @Column(columnDefinition = "int not null")
    private Integer numberOfCourses;

}
