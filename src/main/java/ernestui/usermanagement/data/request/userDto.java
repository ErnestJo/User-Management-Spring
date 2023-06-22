package ernestui.usermanagement.data.request;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 19/06/2023 - 17:31
 * @project user-management
 */
@Data
public class userDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int genderId;
    private List<Long> roles;
    private int active;
    private Date dob;
}
