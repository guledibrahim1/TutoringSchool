package org.guledibrahim.schoolms.controllers;

import org.guledibrahim.schoolms.dto.TutorDTO;
import org.guledibrahim.schoolms.models.Tutor;
import org.guledibrahim.schoolms.services.TutorService;
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
public class TutorController {

    private TutorService tutorService;

    @Autowired
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping("/register-tutor")
    public String showTutorRegistrationForm(Model model) {

        // create a model object to store form data

        TutorDTO tutor = new TutorDTO();
        model.addAttribute("tutor", tutor);
        return "register-tutor";
    }

    @PostMapping("/register-tutor/save")
    public String tutorRegistration(@Valid @ModelAttribute("tutor") TutorDTO tutorDTO,
                                    BindingResult result,
                                    Model model) {
        Tutor existingTutor = tutorService.findTutorByEmail(tutorDTO.getEmail());
        if (existingTutor != null && existingTutor.getEmail() != null && !existingTutor.getEmail().isEmpty()) {
            result.rejectValue("email", null, "There is already an account registered with the same email");
        }
        if (result.hasErrors()) {
            model.addAttribute("tutor", tutorDTO);
            return "/register-tutor";
        }
        tutorService.saveTutor(tutorDTO);
        return "redirect:/register-tutor?success";
    }

    @GetMapping("/tutors")
    public String tutors(Model model) {
        List<TutorDTO> tutors = tutorService.findAllTutors();
        model.addAttribute("tutors", tutors);
        return "tutors";
    }
}
