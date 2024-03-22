package org.guledibrahim.schoolms.controllers;
import org.guledibrahim.schoolms.dto.SubjectDTO;
import org.guledibrahim.schoolms.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import java.util.List;

@Controller
public class SubjectController {

    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/add-subject")
    public String showAddSubjectForm(Model model) {
        SubjectDTO subject = new SubjectDTO();
        model.addAttribute("subject", subject);
        return "add-subject";
    }

    @PostMapping("/add-subject/save")
    public String saveSubject(@Valid @ModelAttribute("subject") SubjectDTO subjectDto,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            model.addAttribute("subject", subjectDto);
            return "/add-subject";
        }
        subjectService.saveSubject(subjectDto);
        return "redirect:/add-subject?success";
    }

    @GetMapping("/subjects")
    public String subjects(Model model) {
        List<SubjectDTO> subjects = subjectService.findAllSubjects();
        model.addAttribute("subjects", subjects);
        return "subjects";
    }
}
