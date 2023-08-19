# Educational Platform

## Course Class:

- id : Integer
- name : String (unique)
- level : String (check Beginner or Intermediate or  Advanced)
- durationInHours: Integer (min 2 hour)
- description : String (min 5 letters)
- coursePresenter : String
- numberOfRegistered :Integer (Positive)

 End points:
- CRUD
- Get course data by name
- Search course by level
- Sort courses by duration from min to max
- Get course by highest number of registered

## Trainee Class:

- id : Integer
- name : String
- major : String
- email : String (valid email ، unique)
- password : String (use pattren) 
- numberOfCourses : Integer

 End points:
- CRUD
- Get trainee data by id
- Check if the trainee has a medal (more than 10 courses)
- Get all trainees that have medals
- Sort trainees by number of courses from max to min


## Teacher Class:

- id : Integer
- email : String (valid email ، unique)
- password : String (use pattren)
- name : String
- courses : String 
- salary : Double
- annualLeave : Boolean (must be false)

 End points:
- CRUD
- Get teacher data by id
- Add bonus to salary
- Annual leave request