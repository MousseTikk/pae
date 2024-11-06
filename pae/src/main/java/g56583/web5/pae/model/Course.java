package g56583.web5.pae.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    private String id;
    private String title;
    private int crédits;

    @ManyToMany(mappedBy = "programmes")
    private List<Student> subscribers;
    @Override
    public String toString() {
        return "Course [id=" + id + ", title=" + title + ", credits=" + crédits + "]";
    }

}
