package g56583.web5.pae.DB;

import org.springframework.data.repository.CrudRepository;

import g56583.web5.pae.model.Student;

public interface StudentDB extends CrudRepository<Student, Integer> {
    // Spring Data JPA générera automatiquement les méthodes CRUD pour Student
}

