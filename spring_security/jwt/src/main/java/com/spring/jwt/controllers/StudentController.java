package com.spring.jwt.controllers;

import com.spring.jwt.models.Student;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

  private List<Student> students =
      new ArrayList<Student>(List.of(new Student(1, "Shres", 95), new Student(2, "Pdvd", 99)));

  @GetMapping("/students")
  public List<Student> getStudents() {
    return students;
  }

  @GetMapping("csrf-token")
  public CsrfToken getCsrfToken(HttpServletRequest req) {
    return (CsrfToken) req.getAttribute("_csrf");
  }

  @PostMapping("/students")
  public Student addStudent(@RequestBody Student student) {
    this.students.add(student);
    return student;
  }
}
