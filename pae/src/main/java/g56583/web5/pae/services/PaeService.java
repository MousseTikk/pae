package g56583.web5.pae.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g56583.web5.pae.DB.CourseDB;
import g56583.web5.pae.DB.StudentDB;
import g56583.web5.pae.model.Course;
import g56583.web5.pae.model.Student;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class PaeService {

    @Autowired
    private CourseDB courseDB;

    @Autowired
    private StudentDB studentDB;

    public List<Course> getAllCourses() {
        return (List<Course>) courseDB.findAll();
    }

    /**
     * Affiche le nom de l'étudiant et la liste des cours de son PAE
     */
    public void getCourse(int matricule) {
        Optional<Student> optionalStudent = studentDB.findById(matricule);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            StringBuilder courses = new StringBuilder();
            for (Course course : student.getProgrammes()) {
                courses.append(course.getTitle()).append("\n"); // Afficher uniquement le titre du cours
            }
            log.info("\nNom: " + student.getName() + "\nCours:\n" + courses);
        } else {
            log.warn("Étudiant avec le matricule " + matricule + " non trouvé.");
        }
    }

    /**
     * Inscrit un étudiant à un cours en utilisant le matricule de l'étudiant et le sigle du cours
     */
    public void updateCourse(int matricule, String sigle) {
        Optional<Student> optionalStudent = studentDB.findById(matricule);
        Optional<Course> optionalCourse = courseDB.findById(sigle);

        if (optionalStudent.isPresent() && optionalCourse.isPresent()) {
            Student student = optionalStudent.get();
            Course course = optionalCourse.get();
            
            List<Course> courses = student.getProgrammes();
            if (!courses.contains(course)) { // Évite les doublons
                courses.add(course);
                student.setProgrammes(courses);
                studentDB.save(student); // Sauvegarde de l'étudiant pour persister la mise à jour
                log.info("Étudiant " + student.getName() + " inscrit au cours " + course.getTitle());
            } else {
                log.info("L'étudiant " + student.getName() + " est déjà inscrit au cours " + course.getTitle());
            }
        } else {
            if (!optionalStudent.isPresent()) {
                log.warn("Étudiant avec le matricule " + matricule + " non trouvé.");
            }
            if (!optionalCourse.isPresent()) {
                log.warn("Cours avec le sigle " + sigle + " non trouvé.");
            }
        }
    }
}
