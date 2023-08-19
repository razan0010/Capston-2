package com.example.educationalplatform.Controller;

import com.example.educationalplatform.API.ApiResponse;
import com.example.educationalplatform.Model.Trainee;
import com.example.educationalplatform.Service.TraineeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/trainee/")
public class TraineeController {

    private final TraineeService traineeService;

    @GetMapping("get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(traineeService.getAll());
    }


    @PostMapping("add")
    public ResponseEntity addTrainee(@RequestBody @Valid Trainee trainee){
        traineeService.addTrainee(trainee);
        return ResponseEntity.status(200).body( new ApiResponse("Trainee added"));
    }


    @PutMapping("update/{id}")
    public ResponseEntity updateTrainee(@PathVariable Integer id, @RequestBody @Valid Trainee trainee){
        traineeService.updateTrainee(id, trainee);
        return ResponseEntity.status(200).body( new ApiResponse("Trainee updated"));
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteTrainee(@PathVariable Integer id){
        traineeService.deleteTrainee(id);
        return ResponseEntity.status(200).body( new ApiResponse("Trainee deleted"));
    }


    @GetMapping("get-by-id/{id}")
    public ResponseEntity getTraineeById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(traineeService.getTraineeById(id));
    }


    @GetMapping("check-medal/{id}")
    public ResponseEntity checkMedal(@PathVariable Integer id){
        return ResponseEntity.status(200).body(traineeService.checkMedal(id));
    }


    @GetMapping("get-trainees-with-medal")
    public ResponseEntity getTraineesWithMedal(){
        return ResponseEntity.status(200).body(traineeService.getTraineesWithMedal());
    }


    @GetMapping("sort-by-NumOfCourses")
    public ResponseEntity sortByNumOfCourses(){
        return ResponseEntity.status(200).body(traineeService.sortByNumOfCourses());
    }

}
