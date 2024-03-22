package org.guledibrahim.schoolms.impl;
import org.guledibrahim.schoolms.dto.TutorDTO;
import org.guledibrahim.schoolms.models.Tutor;
import org.guledibrahim.schoolms.repositories.TutorRepository;
import org.guledibrahim.schoolms.services.TutorService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TutorServiceImpl implements TutorService {
    private TutorRepository tutorRepository;
    private PasswordEncoder passwordEncoder;

    public TutorServiceImpl(TutorRepository tutorRepository, PasswordEncoder passwordEncoder) {
        this.tutorRepository = tutorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveTutor(TutorDTO tutorDTO) {
        Tutor tutor = new Tutor();
        tutor.setName(tutorDTO.getFirstName() + " " + tutorDTO.getLastName());
        tutor.setEmail(tutorDTO.getEmail());
        tutor.setEmail(tutorDTO.getEmail());

        // Encrypt the password using Spring Security
        tutor.setPassword(passwordEncoder.encode(tutorDTO.getPassword()));
        tutorRepository.save(tutor);
    }

    @Override
    public Tutor findTutorByEmail(String email) {
        return tutorRepository.findByEmail(email);
    }

    @Override
    public List<TutorDTO> findAllTutors() {
        List<Tutor> tutors = tutorRepository.findAll();
        return tutors.stream()
                .map(this::mapToTutorDTO)
                .collect(Collectors.toList());
    }

    private TutorDTO mapToTutorDTO(Tutor tutor) {
        TutorDTO tutorDTO = new TutorDTO();

        String[] str = tutor.getName().split(" ");
        tutorDTO.setFirstName(str[0]);
        tutorDTO.setLastName(str[1]);
        tutorDTO.setEmail(tutor.getEmail());
        return tutorDTO;
    }
}
