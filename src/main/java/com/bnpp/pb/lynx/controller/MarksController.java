package com.bnpp.pb.lynx.controller;

import com.bnpp.pb.lynx.model.ExamType;
import com.bnpp.pb.lynx.model.Marks;
import com.bnpp.pb.lynx.model.Student;
import com.bnpp.pb.lynx.model.Subject;
import com.bnpp.pb.lynx.service.MarksService;
import com.bnpp.pb.lynx.service.StudentService;
import com.bnpp.pb.lynx.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

public class MarksController {

    private MarksService marksService;
    private StudentService studentService;
    private SubjectService subjectService;
    
    public void setMarksService(MarksService marksService) {
        this.marksService = marksService;
    }
    
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    
    @RequestMapping(value = "/marks", method = RequestMethod.GET)
    public String getAllMarks(Model model) {
        model.addAttribute("marksList", marksService.getAllMarks());
        model.addAttribute("marks", new Marks());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("examTypes", Arrays.asList(ExamType.values()));
        return "marks";
    }
    
    @RequestMapping(value = "/marks", method = RequestMethod.POST)
    public String addMarks(@ModelAttribute("marks") Marks marks) {
        marksService.addMarks(marks);
        return "redirect:/marks";
    }
    
    @RequestMapping(value = "/marks/{id}/edit", method = RequestMethod.GET)
    public String editMarksForm(@PathVariable Long id, Model model) {
        Marks marks = marksService.getMarksById(id);
        model.addAttribute("marks", marks);
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("examTypes", Arrays.asList(ExamType.values()));
        return "editMarks";
    }
    
    @RequestMapping(value = "/marks/{id}", method = RequestMethod.POST)
    public String updateMarks(@ModelAttribute("marks") Marks marks) {
        marksService.updateMarks(marks);
        return "redirect:/marks";
    }
    
    @RequestMapping(value = "/marks/{id}/delete", method = RequestMethod.GET)
    public String deleteMarks(@PathVariable Long id) {
        marksService.removeMarks(id);
        return "redirect:/marks";
    }
    
    @RequestMapping(value = "/viewMarks", method = RequestMethod.GET)
    public String viewMarksForm(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("examTypes", Arrays.asList(ExamType.values()));
        return "viewMarksForm";
    }
    
    @RequestMapping(value = "/viewMarks", method = RequestMethod.POST)
    public String viewMarks(@RequestParam("rollNumber") String rollNumber, 
                           @RequestParam("examType") ExamType examType, 
                           Model model) {
        Student student = studentService.getStudentByRollNumber(rollNumber);
        List<Marks> marksList = marksService.getMarksByStudentAndExamType(rollNumber, examType);
        
        model.addAttribute("student", student);
        model.addAttribute("marksList", marksList);
        model.addAttribute("examType", examType);
        
        return "viewMarks";
    }
    
    @RequestMapping(value = "/topRankers", method = RequestMethod.GET)
    public String viewTopRankersForm(Model model) {
        model.addAttribute("examTypes", Arrays.asList(ExamType.values()));
        return "topRankersForm";
    }
    
    @RequestMapping(value = "/topRankers", method = RequestMethod.POST)
    public String viewTopRankers(@RequestParam("examType") ExamType examType, Model model) {
        model.addAttribute("topRankers", marksService.getTopRankers(examType, 3));
        model.addAttribute("examType", examType);
        return "topRankers";
    }
} 