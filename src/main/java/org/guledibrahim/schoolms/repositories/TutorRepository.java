package org.guledibrahim.schoolms.repositories;
import org.guledibrahim.schoolms.models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    Tutor findByEmail(String email);
}
