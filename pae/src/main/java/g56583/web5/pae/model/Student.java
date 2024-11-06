package g56583.web5.pae.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "hibernate_sequence", allocationSize = 1)    
    private int matricule;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Section section;
    @ManyToMany
    private List<Course> programmes;


    @Builder
    public Student(String name, Gender gender, Section section){
        this.name = name;
        this.gender = gender;
        this.section = section;
    }

    public Student(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Student [matricule=" + matricule + ", name=" + name + ", gender=" + gender + ", section=" + section + "]";
    }
}
