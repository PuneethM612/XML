package com.bnpp.pb.lynx.controller;

import com.bnpp.pb.lynx.model.Subject;
import com.bnpp.pb.lynx.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class SubjectController {

    private SubjectService subjectService;
    
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    
    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public String getAllSubjects(Model model) {
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("subject", new Subject());
        return "subjects";
    }
    
    @RequestMapping(value = "/subjects", method = RequestMethod.POST)
    public String addSubject(@ModelAttribute("subject") Subject subject) {
        subjectService.addSubject(subject);
        return "redirect:/subjects";
    }
    
    @RequestMapping(value = "/subjects/{id}/edit", method = RequestMethod.GET)
    public String editSubjectForm(@PathVariable Long id, Model model) {
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);
        return "editSubject";
    }
    
    @RequestMapping(value = "/subjects/{id}", method = RequestMethod.POST)
    public String updateSubject(@ModelAttribute("subject") Subject subject) {
        subjectService.updateSubject(subject);
        return "redirect:/subjects";
    }
    
    @RequestMapping(value = "/subjects/{id}/delete", method = RequestMethod.GET)
    public String deleteSubject(@PathVariable Long id) {
        subjectService.removeSubject(id);
        return "redirect:/subjects";
    }
} 