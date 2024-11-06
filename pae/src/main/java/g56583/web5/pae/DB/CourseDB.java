package g56583.web5.pae.DB;

import org.springframework.data.repository.CrudRepository;

import g56583.web5.pae.model.Course;

public interface CourseDB extends CrudRepository<Course, String> {
    // Spring Data JPA générera automatiquement les méthodes CRUD pour Course
}

