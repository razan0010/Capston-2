package com.example.educationalplatform.Rrpository;

import com.example.educationalplatform.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findCourseById(Integer id);
    Course findCourseByName( String name);
    List<Course> searchCourseByLevel(String level);
    Course findCourseByNumberOfRegistered(Integer number);
    @Query("select c from Course c ORDER BY c.durationInHours asc")
    List<Course> sortCourseByDuration();
   @Query("select max(c.numberOfRegistered) from Course c")
    Integer getHighestNumOfRegistered();

}
