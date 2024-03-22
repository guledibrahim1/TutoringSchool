package org.guledibrahim.schoolms.services;

import org.guledibrahim.schoolms.dto.SubjectDTO;
import org.guledibrahim.schoolms.models.Subject;
import java.util.List;

public interface SubjectService {
    void saveSubject(SubjectDTO subjectDTO);

    Subject findSubjectById(Long id);

    List<SubjectDTO> findAllSubjects();
}
