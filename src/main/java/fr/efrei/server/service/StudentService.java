package fr.efrei.server.service;

import fr.efrei.server.domain.Student;
import fr.efrei.server.repository.StudentRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    public final StudentRepository studentRepository;

    // Constructor for initializing the StudentService with a StudentRepository.
    public StudentService(StudentRepository studentRepository) {
        // Assign the provided StudentRepository to the class field.
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        // A method to retrieve a list of all students using the injected StudentRepository.
        return studentRepository.findAll();
    }

    public Student findById(Integer id){
        return studentRepository.findById(id).orElse(null);
    }

    //CREATE
    public Student create(Student newStudent) {
        // Create a new Student with default values.
        Student student = new Student();

        // Update the student's details with the values from the provided newStudent.
        student.setName(newStudent.getName());
        student.setAge(newStudent.getAge());

        // Save the student to the repository and return the saved instance.
        return studentRepository.save(student);
    }



    //UPDATE
    public Student update(Student student) {
        // Retrieve the existing student from the repository based on the provided ID.
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        // Check if the student with the given ID exists.
        if (optionalStudent.isPresent()) {
            // If found, update the existing student's details with the values from the provided student.
            Student oldStudent = optionalStudent.get();
            oldStudent.setName(student.getName());
            oldStudent.setAge(student.getAge());
            // Save the updated student to the repository and return the saved instance.
            return studentRepository.save(oldStudent);
        }
        // Return null if the student with the provided ID is not found.
        return null;
    }

    public void delete(Integer id) {
        // Find the student in the repository based on the provided ID.
        studentRepository.findById(id)
                // If the student exists, delete it from the repository using method reference.
                .ifPresent(studentRepository::delete);
    }
}
