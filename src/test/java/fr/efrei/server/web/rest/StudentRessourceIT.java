package fr.efrei.server.web.rest;

import fr.efrei.server.domain.Student;
import fr.efrei.server.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class StudentRessourceIT{

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    void createStudent() throws Exception {
        int databaseSizeBeforeCreate = studentRepository.findAll().size();
        assertThat(databaseSizeBeforeCreate).isEqualTo(0);

        Student student = new Student();
        student.setName("Pierre");
        studentRepository.save(student);

        List<Student> studentList = studentRepository.findAll();
        assertThat(studentList.size()).isEqualTo(1);
    }

    @Test
    @Transactional
    void getStudent() throws Exception {
        // Arrange
        Student existingStudent = new Student();
        existingStudent.setName("Quentin");
        studentRepository.save(existingStudent);
        // Act
        Student retrievedStudent = studentRepository.findById(existingStudent.getId()).orElse(null);
        // Assert
        assertThat(retrievedStudent)
                .isNotNull()
                .extracting(Student::getName)
                .isEqualTo("Quentin");
    }


    @Test
    @Transactional
    void updateStudent() throws Exception {
        // Arrange
        Student existingStudent = studentRepository.save(new Student());
        // Act
        existingStudent.setName("Quentin");
        studentRepository.save(existingStudent);
        // Assert
        assertThat(studentRepository.findById(existingStudent.getId()))
                .isPresent()
                .get()
                .extracting(Student::getName)
                .isEqualTo("Quentin");
    }

    @Test
    @Transactional
    void deleteStudent() throws Exception {
        // Arrange
        Student existingStudent = studentRepository.save(new Student());
        // Act
        int databaseSizeBeforeDelete = studentRepository.findAll().size();
        assertThat(databaseSizeBeforeDelete).isEqualTo(1);
        studentRepository.deleteById(existingStudent.getId());
        // Assert
        assertThat(studentRepository.findAll()).hasSize(databaseSizeBeforeDelete - 1);
    }
}
