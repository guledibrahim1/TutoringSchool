package org.guledibrahim.schoolms;
import org.guledibrahim.schoolms.dto.SubjectDTO;
import org.guledibrahim.schoolms.models.Role;
import org.guledibrahim.schoolms.models.Student;
import org.guledibrahim.schoolms.models.Subject;
import org.guledibrahim.schoolms.models.Tutor;
import org.guledibrahim.schoolms.repositories.RoleRepository;
import org.guledibrahim.schoolms.repositories.StudentRepository;
import org.guledibrahim.schoolms.repositories.SubjectRepository;
import org.guledibrahim.schoolms.repositories.TutorRepository;
import org.guledibrahim.schoolms.services.StudentService;
import org.guledibrahim.schoolms.services.SubjectService;
import org.guledibrahim.schoolms.services.TutorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;


@SpringBootTest
class SchoolmsApplicationTests {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private TutorService tutorService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentService studentService;

    @Test
    void testRoleRepositoryFindByName() {
        // Assuming you have a role with name "ADMIN" in your database
        Role role = roleRepository.findByName("STUDENT");
        assertNotNull(role);
        assertEquals("STUDENT", role.getName());
    }

    @Test
    void testStudentRepositoryFindByEmail() {
        // find a student with email "student@example.com" in your database
        Student student = studentRepository.findByEmail("guled@gmail.com");
        assertNotNull(student);
        assertEquals("guled@gmail.com", student.getEmail());
    }

    @Test
    void testTutorRepositoryFindByEmail() {
        // find a tutor with email "tutor@example.com" in your database
        Tutor tutor = tutorRepository.findByEmail("tutor@example.com");
        assertNotNull(tutor);
        assertEquals("tutor@example.com", tutor.getEmail());
    }

    @Test
    void testTutorServiceFindTutorByEmail() {
        // find a tutor with email "tutor@example.com" in your database
        Tutor tutor = tutorService.findTutorByEmail("tutor@example.com");
        assertNotNull(tutor);
        assertEquals("tutor@example.com", tutor.getEmail());
    }

    @Test
    void testSubjectServiceFindSubjectById() {
        // find a subject with id 1 in your database
        Subject subject = subjectService.findSubjectById(1L);
        assertNotNull(subject);
        assertEquals(1L, subject.getId());
    }

    @Test
    void testStudentServiceFindStudentByEmail() {
        // find a student with email "student@example.com" in your database
        Student student = studentService.findStudentByEmail("guled@gmail.com");
        assertNotNull(student);
        assertEquals("guled@gmail.com", student.getEmail());
    }

    @ParameterizedTest
    @ValueSource(strings = {"math", "java", "subject3"})
    void testSubjectServiceSaveSubject(String subjectName) {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName(subjectName);
        subjectService.saveSubject(subjectDTO);

        List<SubjectDTO> subjects = subjectService.findAllSubjects();
        assertTrue(subjects.stream().anyMatch(dto -> dto.getName().equals(subjectName)));
    }
}


