package ernestui.usermanagement.data.response;

import lombok.Data;

import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 19/06/2023 - 17:23
 * @project user-management
 */
@Data
public class userResponseDto {

    private String userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String genderName;
    private List<String> roles;
    private int active;
    private long age;

}
