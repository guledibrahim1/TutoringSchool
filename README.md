# School Management System

The School Management System is a web-based application designed to facilitate the management of tutors, students, and tutoring sessions. It provides a platform for students to find suitable tutors, book tutoring sessions, and manage their learning experience. Tutors can manage their availability, view scheduled sessions, and interact with students.

## Features

- User authentication and authorization (login and logout)
- Tutor management (view tutors, search tutors, view tutor details)
- Student management (view students, update profile information)
- Subject management (view available subjects)
- Tutoring session management (book sessions, view session details, cancel sessions)
- Feedback and rating system for tutors
- Contact functionality between students and tutors

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- Thymeleaf
- HTML/CSS
- MySQL




## Capstone Presentation

### Business Use Case

The School Management System addresses the need for an efficient and centralized platform to connect students with qualified tutors. In many educational institutions, students often struggle to find suitable tutors who can provide personalized assistance in specific subjects. This application bridges that gap by creating a marketplace where students can easily discover tutors based on their expertise, availability, and student feedback. From a business perspective, the system streamlines the tutoring process, reduces administrative overhead, and enhances the overall learning experience for students. It also provides opportunities for tutors to expand their reach, build their reputation, and engage with a larger student base. The application can be leveraged by educational institutions, tutoring centers, or even individual tutors to effectively manage and grow their tutoring services.

### High-level Overview of the Application

The School Management System is a web application that streamlines the process of connecting students with tutors and managing tutoring sessions. It provides a user-friendly interface for students to browse and search for tutors based on their preferences and requirements. Tutors can create profiles, specify their areas of expertise, and manage their availability. The application facilitates the booking and scheduling of tutoring sessions, allowing students and tutors to coordinate their meetings effectively. Additionally, the system incorporates features such as feedback and rating mechanisms, enabling students to provide feedback on their tutoring experiences and helping future students make informed decisions when selecting tutors.
![home.png](..%2F..%2F..%2Fimg%2Fhome.png)
![Contact Us.png](..%2F..%2F..%2Fimg%2FContact%20Us.png)
![About Us.png](..%2F..%2F..%2Fimg%2FAbout%20Us.png)
![Register.png](..%2F..%2F..%2Fimg%2FRegister.png)
![Login.png](..%2F..%2F..%2Fimg%2FLogin.png)
![Students table.png](..%2F..%2F..%2Fimg%2FStudents%20table.png)
![Student logout.png](..%2F..%2F..%2Fimg%2FStudent%20logout.png)
![Course Registration form.png](..%2F..%2F..%2Fimg%2FCourse%20Registration%20form.png)
![Admin-dashboard.png](..%2F..%2F..%2Fimg%2FAdmin-dashboard.png)
![Tutor-view.png](..%2F..%2F..%2Fimg%2FTutor-view.png)
![log file.png](..%2F..%2F..%2Fimg%2Flog%20file.png)







## Entity Relations (ER) Diagram

![Entity Relations(ER).png](..%2F..%2F..%2Fimg%2FEntity%20Relations%28ER%29.png)

# School Management System

## Entities

### 1. Tutor
- **Attributes:**
   - `id` (Primary Key)
   - `email`
   - `name`
   - `password`

### 2. Student
- **Attributes:**
   - `id` (Primary Key)
   - `email`
   - `name`
   - `password`

### 3. Role
- **Attributes:**
   - `id` (Primary Key)
   - `name`

## Relationships

### 1. Tutor and Student:
- **Type:** Many-to-Many
- **Description:** A tutor can teach multiple students, and a student can be taught by multiple tutors. This relationship represents the real-world scenario where a tutor may mentor or teach several students, while a student may receive guidance or lessons from multiple tutors for different subjects or courses.
- **Implementation:** A join table named "tutor_student" will be created to connect the Tutor and Student entities. The join table will have foreign keys referencing the primary keys of both the Tutor and Student tables.

### 2. Tutor and Role:
- **Type:** Many-to-One
- **Description:** A tutor can have one specific role, but a role can be assigned to multiple tutors. In a typical educational system, tutors may have different roles such as "Math Tutor," "English Tutor," or "Science Tutor." Each tutor is assigned a specific role based on their expertise or the subjects they teach.
- **Implementation:** The Tutor entity will have a foreign key column named "role_id" that references the primary key of the Role entity. This establishes the many-to-one relationship between Tutor and Role.




## Class Diagram

```plantuml


class Tutor {
- id: Long
- email: String
- name: String
- password: String
- role: Role
- students: List<Student>
+ getId(): Long
+ setId(id: Long): void
+ getEmail(): String
+ setEmail(email: String): void
+ getName(): String
+ setName(name: String): void
+ getPassword(): String
+ setPassword(password: String): void
+ getRole(): Role
+ setRole(role: Role): void
+ getStudents(): List<Student>
+ setStudents(students: List<Student>): void
}

    class Student {
        - id: Long
        - email: String
        - name: String
        - password: String
        - tutors: List<Tutor>
        + getId(): Long
        + setId(id: Long): void
        + getEmail(): String
        + setEmail(email: String): void
        + getName(): String
        + setName(name: String): void
        + getPassword(): String
        + setPassword(password: String): void
        + getTutors(): List<Tutor>
        + setTutors(tutors: List<Tutor>): void
    }

    class Role {
        - id: Long
        - name: String
        - tutors: List<Tutor>
        + getId(): Long
        + setId(id: Long): void
        + getName(): String
        + setName(name: String): void
        + getTutors(): List<Tutor>
        + setTutors(tutors: List<Tutor>): void
    }

    class Subject {
        - id: Long
        - name: String
        + getId(): Long
        + setId(id: Long): void
        + getName(): String
        + setName(name: String): void
    }

    Tutor "1" --> "1" Role : has
    Tutor "*" <--> "*" Student : teaches


### Lessons Learned from the Case Study Project

Through the development of the School Management System, several valuable lessons were learned:

1. Understanding the importance of a well-designed database schema to ensure efficient data storage and retrieval.
2. Implementing user authentication and authorization mechanisms to secure the application and protect user data.
3. Utilizing Spring Boot and Spring Data JPA to streamline the development process and simplify database interactions.
4. Leveraging Thymeleaf templating engine to create dynamic and interactive user interfaces.
5. Implementing search and filtering functionalities to enhance user experience and facilitate easy navigation.
6. Incorporating feedback and rating systems to promote trust and transparency within the tutoring community.
7. Managing user roles and permissions to ensure appropriate access control and data privacy.
8. Designing intuitive user interfaces and workflows to enhance usability and user adoption.

### Additional Features for Future Enhancements

1. Integration with a video conferencing platform to enable online tutoring sessions.
2. Implementing a messaging system for direct communication between students and tutors.
3. Adding a payment gateway to facilitate secure and convenient transactions for tutoring services.
4. Incorporating a recommendation engine to suggest tutors based on student preferences and past interactions.
5. Providing a mobile app version of the system for enhanced accessibility and on-the-go usage.
6. Implementing a scheduling calendar to help tutors manage their availability more effectively.
7. Offering a resource library with study materials, practice questions, and educational content.
8. Integrating with external educational platforms or learning management systems for seamless data synchronization.
9. Providing analytics and reporting features to track student progress and measure the effectiveness of tutoring sessions.
10. Implementing a gamification system with badges, rewards, and leaderboards to motivate and engage students.
