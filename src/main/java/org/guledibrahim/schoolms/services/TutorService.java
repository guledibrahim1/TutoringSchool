package org.guledibrahim.schoolms.services;


import org.guledibrahim.schoolms.dto.TutorDTO;
import org.guledibrahim.schoolms.models.Tutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TutorService {
    void saveTutor(TutorDTO tutorDTO);
    Tutor findTutorByEmail(String email);
    List<TutorDTO> findAllTutors();
}
