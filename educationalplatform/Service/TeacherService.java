package com.example.educationalplatform.Service;

import com.example.educationalplatform.API.ApiException;
import com.example.educationalplatform.Model.Teacher;
import com.example.educationalplatform.Rrpository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }


    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }


    public void updateTeacher(Integer id, Teacher teacher){
        Teacher teacher1 = teacherRepository.getTeacherById(id);

        if (teacher1 == null) {
            throw new ApiException("Id not found");
        }

        teacher1.setName(teacher.getName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setPassword(teacher.getPassword());
        teacher1.setCourses(teacher.getCourses());
        teacher1.setSalary(teacher.getSalary());

        teacherRepository.save(teacher1);
    }


    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.getTeacherById(id);

        if (teacher == null) {
            throw new ApiException("Id not found");
        }
        teacherRepository.delete(teacher);
    }


//    Get teacher data by id
    public Teacher getTeacherById(Integer id){
        Teacher teacher = teacherRepository.getTeacherById(id);

        if (teacher == null) {
            throw new ApiException("Id not found");
        }

        return teacher;
    }


//    Add bonus to salary
    public void addBonus(Integer id , Double bonus){
        Teacher teacher = teacherRepository.getTeacherById(id);

        if (teacher == null) {
            throw new ApiException("Id not found");
        }
        if (bonus <0){
            throw new ApiException("Bonus must be positive number");
        }

        teacher.setSalary(teacher.getSalary()+ bonus);
        teacherRepository.save(teacher);
    }


//    Annual leave request
    public void requestAnnualLeave(Integer id){
        Teacher teacher = teacherRepository.getTeacherById(id);

        if (teacher == null) {
            throw new ApiException("Id not found");
        }
        if (teacher.isAnnualLeave()){
            throw new ApiException("The teacher is already on annual leave!");
        }

        teacher.setAnnualLeave(true);
        teacherRepository.save(teacher);
    }
}
