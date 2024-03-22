package org.guledibrahim.schoolms.impl;


import org.guledibrahim.schoolms.dto.StudentDTO;
import org.guledibrahim.schoolms.models.Role;
import org.guledibrahim.schoolms.models.Student;
import org.guledibrahim.schoolms.repositories.RoleRepository;
import org.guledibrahim.schoolms.repositories.StudentRepository;
import org.guledibrahim.schoolms.services.StudentService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public StudentServiceImpl(StudentRepository studentRepository, RoleRepository roleRepository,
                              PasswordEncoder passwordEncoder) {
        super();
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getFirstName() + " " + studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());

        // Encrypt the password using Spring Security
        student.setPassword(passwordEncoder.encode(studentDTO.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null) {
            role = checkRoleExist();
        }
        student.setRoles(Arrays.asList(role));
        studentRepository.save(student);
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    @Override
    public Student findStudentByEmail(String email) {

        return studentRepository.findByEmail(email);
    }

    @Override
    public List<StudentDTO> findAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map((student) -> mapToStudentDTO(student))
                .collect(Collectors.toList());
    }

    private StudentDTO mapToStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();

        String[] str = student.getName().split(" ");
        studentDTO.setFirstName(str[0]);
        studentDTO.setLastName(str[1]);
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }
}


