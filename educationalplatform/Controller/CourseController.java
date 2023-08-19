package com.example.educationalplatform.Controller;

import com.example.educationalplatform.API.ApiResponse;
import com.example.educationalplatform.Model.Course;
import com.example.educationalplatform.Service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/va/course/")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(courseService.getAll());
    }


    @PostMapping("add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body( new ApiResponse("Course added"));
    }


    @PutMapping("update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody @Valid Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body( new ApiResponse("Course updated"));
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body( new ApiResponse("Course deleted"));

    }


    @GetMapping("get-by-name/{name}")
    public ResponseEntity findCourseByName(@PathVariable String name){
        return ResponseEntity.status(200).body(courseService.findCourseByName(name));
    }


    @GetMapping("search-by-level/{level}")
    public ResponseEntity searchCourseByLevel(@PathVariable String level){
        return ResponseEntity.status(200).body(courseService.searchCourseByLevel(level));
    }


    @GetMapping("sort-by-duration")
    public ResponseEntity sortCourseByDuration(){
        return ResponseEntity.status(200).body(courseService.sortCourseByDuration());
    }


    @GetMapping("highest-registered")
    public ResponseEntity getHighestNumOfRegistered(){
        return ResponseEntity.status(200).body(courseService.getHighestNumOfRegistered());
    }
}
