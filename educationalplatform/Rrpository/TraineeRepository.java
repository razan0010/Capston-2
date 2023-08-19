package com.example.educationalplatform.Rrpository;

import com.example.educationalplatform.Model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Integer> {

    Trainee findTraineeById(Integer id);
    @Query("select t from Trainee t where t.numberOfCourses >= 10")
    List<Trainee> checkMedal();
    @Query("select t from Trainee t ORDER BY t.numberOfCourses desc")
    List<Trainee> sortByNumOfCourses();


}
