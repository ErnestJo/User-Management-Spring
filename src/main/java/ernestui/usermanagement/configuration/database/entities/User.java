package ernestui.usermanagement.configuration.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 19/06/2023 - 15:05
 * @project user-management
 */
@Entity
@Table (name = "User")
@NoArgsConstructor
@Data
public class User {
    @Id
    private String userId;

    private String firstName;

    private String middleName;

    private String lastName;

    private Date dob;

    private String email;

    private String  phoneNumber;

    public int getActive() {
        return active;
    }
    public void setActive(int active) {
        this.active = active;
    }
    private int active;

    private String password;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private List<Role> roles = new ArrayList<>();

    public User(String userId, String firstName, String middleName, String lastName, Date dob, String email, String phoneNumber, int active, String password, Gender gender, List<Role> roles) {
        this.userId = userId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.active = active;
        this.password = password;
        this.gender = gender;
        this.roles = roles;
    }

    public void addRole(Role role){
            roles.add(role);
    }

    public void removeRole(Role role){
        roles.remove(role);
    }

}
