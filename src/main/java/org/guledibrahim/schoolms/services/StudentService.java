package org.guledibrahim.schoolms.services;

import org.guledibrahim.schoolms.dto.StudentDTO;
import org.guledibrahim.schoolms.models.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(StudentDTO studentDTO);
    Student findStudentByEmail(String email);
    List<StudentDTO> findAllStudents();
}
