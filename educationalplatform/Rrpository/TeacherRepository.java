package com.example.educationalplatform.Rrpository;

import com.example.educationalplatform.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Teacher getTeacherById(Integer id);

}
