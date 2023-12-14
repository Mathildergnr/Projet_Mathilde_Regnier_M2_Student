package fr.efrei.server.web.rest;

import fr.efrei.server.domain.Student;
import fr.efrei.server.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import fr.efrei.server.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@RequestMapping("/api")
public class StudentRessource {

    public final StudentService studentService;

    public StudentRessource(StudentService studentService) {
        this.studentService = studentService;
    }

    //READ
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.findById(id);
    }


    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    //CREATE
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        return studentService.create(student);
    }

    //UPDATE
    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student){
        return studentService.update(student);
    }

    //DELETE
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Integer id) {
            studentService.delete(id);
    }
}
