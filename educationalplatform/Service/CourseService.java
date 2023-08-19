package com.example.educationalplatform.Service;

import com.example.educationalplatform.API.ApiException;
import com.example.educationalplatform.Model.Course;
import com.example.educationalplatform.Rrpository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

//      get all courses
    public List<Course> getAll(){
        return courseRepository.findAll();
    }


//    add new course
    public void addCourse(Course course){
        courseRepository.save(course);
    }


//    update course
    public void updateCourse(Integer id , Course course){
        Course course1 = courseRepository.findCourseById(id);

        if (course1 == null){
            throw new ApiException("Id not found");
        }

        course1.setName(course.getName());
        course1.setLevel(course.getLevel());
        course1.setDescription(course.getDescription());
        course1.setDurationInHours(course.getDurationInHours());
        course1.setCoursePresenter(course.getCoursePresenter());
        course1.setNumberOfRegistered(course.getNumberOfRegistered());

        courseRepository.save(course1);
    }


//    delete course
    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);

        if (course == null){
            throw new ApiException("Id not found");
        }

        courseRepository.delete(course);
    }


//    get course data by name
    public Course findCourseByName(String name){
        Course course = courseRepository.findCourseByName(name);

        if (course == null){
            throw new ApiException("Name not found");
        }

        return course;
    }


//    Search course by level
    public List<Course> searchCourseByLevel(String level){
        List<Course> course = courseRepository.searchCourseByLevel(level);

        if (course.isEmpty()){
            throw new ApiException("No courses for this level yet");
        }

        return course;
    }


//    Sort courses by duration
    public List<Course> sortCourseByDuration(){
        if(getAll().isEmpty()){
            throw new ApiException("No courses");
        }
        return courseRepository.sortCourseByDuration();
    }


//    get course that has the highest number of registered
    public Course getHighestNumOfRegistered(){
        if(getAll().isEmpty()){
            throw new ApiException("No courses");
        }

        Integer highest = courseRepository.getHighestNumOfRegistered();
        return courseRepository.findCourseByNumberOfRegistered(highest);
    }
}
