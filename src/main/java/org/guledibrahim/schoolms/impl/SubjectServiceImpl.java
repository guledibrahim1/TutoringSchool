package org.guledibrahim.schoolms.impl;

import org.guledibrahim.schoolms.dto.SubjectDTO;
import org.guledibrahim.schoolms.models.Subject;
import org.guledibrahim.schoolms.models.Tutor;
import org.guledibrahim.schoolms.repositories.SubjectRepository;
import org.guledibrahim.schoolms.repositories.TutorRepository;
import org.guledibrahim.schoolms.services.SubjectService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {
    private SubjectRepository subjectRepository;
    private TutorRepository tutorRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository, TutorRepository tutorRepository) {
        this.subjectRepository = subjectRepository;
        this.tutorRepository = tutorRepository;
    }

    @Override
    public void saveSubject(SubjectDTO subjectDto) {
        Subject subject = new Subject();
        subject.setName(subjectDto.getName());

        Tutor tutor = tutorRepository.findById(subjectDto.getTutorId())
                .orElseThrow(() -> new RuntimeException("Tutor not found"));
        subject.setTutor(tutor);

        subjectRepository.save(subject);
    }

    @Override
    public Subject findSubjectById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    @Override
    public List<SubjectDTO> findAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream()
                .map(this::mapToSubjectDto)
                .collect(Collectors.toList());
    }

    private SubjectDTO mapToSubjectDto(Subject subject) {
        SubjectDTO subjectDto = new SubjectDTO();
        subjectDto.setId(subject.getId());
        subjectDto.setName(subject.getName());
        subjectDto.setTutorId(subject.getTutor().getId());
        return subjectDto;
    }
}
