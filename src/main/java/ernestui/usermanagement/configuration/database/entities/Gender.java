package ernestui.usermanagement.configuration.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 19/06/2023 - 15:39
 * @project user-management
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gender")
public class Gender {

    @Id

    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String gender_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender_name() {
        return gender_name;
    }

    public void setGender_name(String gender_name) {
        this.gender_name = gender_name;
    }
}
