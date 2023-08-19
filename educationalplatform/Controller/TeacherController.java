package com.example.educationalplatform.Controller;

import com.example.educationalplatform.API.ApiResponse;
import com.example.educationalplatform.Model.Teacher;
import com.example.educationalplatform.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/teacher/")
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(teacherService.getAll());
    }


    @PostMapping("add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body( new ApiResponse("Teacher added"));
    }


    @PutMapping("update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body( new ApiResponse("Teacher updated"));
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body( new ApiResponse("Teacher deleted"));
    }


    @GetMapping("get-by-id/{id}")
    public ResponseEntity getTeacherById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherById(id));
    }


    @GetMapping("add-bonus/{id}/{bonus}")
    public ResponseEntity addBonus(@PathVariable Integer id , @PathVariable Double bonus){
        teacherService.addBonus(id, bonus);
        return ResponseEntity.status(200).body(new ApiResponse("The bonus added"));
    }


    @GetMapping("requestAnnualLeave/{id}")
    public ResponseEntity requestAnnualLeave(@PathVariable Integer id){
        teacherService.requestAnnualLeave(id);
        return ResponseEntity.status(200).body(new ApiResponse("The leave request has been approved"));
    }

}
