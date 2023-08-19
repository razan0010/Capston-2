package com.example.educationalplatform.Service;

import com.example.educationalplatform.API.ApiException;
import com.example.educationalplatform.Model.Trainee;
import com.example.educationalplatform.Rrpository.TraineeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TraineeService {

    private final TraineeRepository traineeRepository;

    public List<Trainee> getAll(){
       return traineeRepository.findAll();
    }


    public void addTrainee(Trainee trainee){
        traineeRepository.save(trainee);
    }


    public void updateTrainee(Integer id, Trainee trainee){
        Trainee trainee1 = traineeRepository.findTraineeById(id);

        if (trainee1 == null) {
            throw new ApiException("Id not found");
        }
        trainee1.setName(trainee.getName());
        trainee1.setMajor(trainee.getMajor());
        trainee1.setEmail(trainee.getEmail());
        trainee1.setPassword(trainee.getPassword());
        trainee1.setNumberOfCourses(trainee.getNumberOfCourses());

        traineeRepository.save(trainee1);
    }


    public void deleteTrainee(Integer id){
        Trainee trainee = traineeRepository.findTraineeById(id);

        if (trainee == null) {
            throw new ApiException("Id not found");
        }
        traineeRepository.delete(trainee);
    }


//    Get trainee data by id
    public Trainee getTraineeById(Integer id){
        Trainee trainee = traineeRepository.findTraineeById(id);

        if (trainee == null) {
            throw new ApiException("Id not found");
        }

        return trainee;
    }


//    Check if the trainee has a medal (if has more than 10 courses)
    public String checkMedal(Integer id){
        Trainee trainee = traineeRepository.findTraineeById(id);

        if (trainee == null) {
            throw new ApiException("Id not found");
        }
        Integer courses = trainee.getNumberOfCourses();
        if (courses >= 10){
            return "The trainee "+ trainee.getName()+ " has medal with "+ courses +" courses";
        } else  return "The trainee "+ trainee.getName()+ " has no medals and has "+ courses +" courses";
    }


//    Get all trainees that have medals
    public List<Trainee> getTraineesWithMedal(){
        if(getAll().isEmpty()){
            throw new ApiException("No Trainees");
        }
        return  traineeRepository.checkMedal();
    }


//    Sort trainees by number of courses from max to min
    public List<Trainee> sortByNumOfCourses() {
        if (getAll().isEmpty()) {
            throw new ApiException("No Trainees");
        }
        return traineeRepository.sortByNumOfCourses();
    }


}


