package com.example.com.springboot.web.rest;

import com.example.com.springboot.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Resource {

    @GetMapping("/students/all")
    public ResponseEntity getAll() {
        Student student = new Student(1L, "Nodir", "Botirov", "3-chi kuhrs");
        Student student1 = new Student(1L, "zarif", "Temurov", "3-chi kuhrs");
        Student student2 = new Student(1L, "Bobur", "Sadullaev", "3-chi kuhrs");
        Student student3 = new Student(1L, "Temur", "Khujanov", "3-chi kuhrs");

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);


        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Student student = new Student(id, "Nodir", "Botirov", "3-chi kurs");
       return ResponseEntity.ok(student);
    }

    @PostMapping("/students")
    public ResponseEntity add(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public ResponseEntity getOne(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String surname,
                                 @RequestParam String course){
        Student student = new Student(id, name, surname, course);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok("Malumot uchirildi");
    }

    @PutMapping("/students{id}")
    public ResponseEntity edit(@PathVariable Long id,
                               @RequestBody Student studentNew){
        Student student = new Student(1L, "Bobur", "Sadullaev", "3-chi kurs");
        student.setName(studentNew.getName());
        student.setSurname(studentNew.getSurname());
        return ResponseEntity.ok(studentNew);
    }


}
