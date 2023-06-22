package ernestui.usermanagement.data;

import ernestui.usermanagement.configuration.database.entities.Role;
import ernestui.usermanagement.configuration.database.entities.User;
import ernestui.usermanagement.data.response.userResponseDto;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 19/06/2023 - 16:55
 * @project user-management
 */
public class mapper {

        public static userResponseDto userResponseDto(User user){
          int age =extracted(user);
            userResponseDto userDto = new userResponseDto();
            userDto.setUserId(userDto.getUserId());
            userDto.setEmail(userDto.getEmail());
            userDto.setFirstName(user.getFirstName());
            userDto.setMiddleName(user.getMiddleName());
            userDto.setGenderName(user.getGender().getGender_name());
            userDto.setActive(user.getActive());
            userDto.setPhoneNumber(user.getPhoneNumber());
            userDto.setAge(age);
            List<String> name = new ArrayList<>();
            List<Role> roles =  user.getRoles();
            for( Role role : roles){
                name.add(role.getRoleName());
            }
            userDto.setRoles(name);
            return userDto;
        }

        public static List<userResponseDto> userResponseDtos(List<User> users){
            List<userResponseDto> userDtos = new ArrayList<>();
            for(User user: users){
                userDtos.add(userResponseDto(user));
            }
            return userDtos;
        }


        private static int extracted(User user) {
            Date dob = user.getDob();
            LocalDate dateOfBirth = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate currentDate = LocalDate.now();
            Period age = Period.between(dateOfBirth, currentDate);
            int years = age.getYears();
            return years;
        }
}
