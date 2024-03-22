package org.guledibrahim.schoolms.repositories;


import org.guledibrahim.schoolms.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>
{

    Student findByEmail(String email);}

