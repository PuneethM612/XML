package com.bnpp.pb.lynx.controller;

import com.bnpp.pb.lynx.model.Student;
import com.bnpp.pb.lynx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class StudentController {

    private StudentService studentService;
    
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("student", new Student());
        return "students";
    }
    
    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return "redirect:/students";
    }
    
    @RequestMapping(value = "/students/{rollNumber}/edit", method = RequestMethod.GET)
    public String editStudentForm(@PathVariable String rollNumber, Model model) {
        Student student = studentService.getStudentByRollNumber(rollNumber);
        model.addAttribute("student", student);
        return "editStudent";
    }
    
    @RequestMapping(value = "/students/{rollNumber}", method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/students";
    }
    
    @RequestMapping(value = "/students/{rollNumber}/delete", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable String rollNumber) {
        studentService.removeStudent(rollNumber);
        return "redirect:/students";
    }
} 