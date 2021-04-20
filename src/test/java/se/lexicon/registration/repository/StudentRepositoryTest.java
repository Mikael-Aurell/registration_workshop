package se.lexicon.registration.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.registration.entity.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {

    StudentRepository studentRepository;
    Student studentTest;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @BeforeEach
    public void setup(){
        studentTest = new Student();
        studentTest.setFirstName("Mikael");
        studentTest.setLastName("Aurell");
        studentTest.setAge(42);
        studentTest.setGender("Male");
        studentTest.setEmail("aurell.mikael@gmail.com");
        studentTest.setPhoneNumber("076-3173768");
        studentTest.setRegisterDate(LocalDateTime.of(1978,04,30,15,03));
        studentTest.setStatus(true);

        studentRepository.save(studentTest);
    }

    @Test
    @DisplayName("Test1 Find By Id")
    public void test_find_by_id(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(students::add);
        String expected = students.get(0).getId();
        Assertions.assertEquals(42, studentRepository.findById(expected).get().getAge());
    }

    @Test
    @DisplayName("Test2 Find all")
    public void test_find_by_all(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(students::add);
        Assertions.assertEquals(42, students.get(0).getAge());
    }
}
