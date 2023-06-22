package ernestui.usermanagement.controller;

import ernestui.usermanagement.configuration.database.entities.Role;
import ernestui.usermanagement.data.GeneralResponse;
import ernestui.usermanagement.data.request.roleDto;
import ernestui.usermanagement.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 19/06/2023 - 17:17
 * @project user-management
 */
@RestController
@RequestMapping("/role")
public class roleController {
    private final RoleService roleService;

    public roleController(RoleService roleService) {
        this.roleService = roleService;
    }

    public <T> GeneralResponse<T> processResponse(String status, String message, T body) {
        GeneralResponse<T> responseWrapper = new GeneralResponse<>();
        responseWrapper.setBody(body);
        responseWrapper.setStatusCode(status);
        responseWrapper.setMessage(message);
        return responseWrapper;
    }

    @PostMapping ("/add")
    public ResponseEntity addCity(@RequestBody final roleDto rDto){
        GeneralResponse response= roleService.addRole(rDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping ("/getAll")
    public ResponseEntity getRoles(){
        GeneralResponse response = roleService.getRoles();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
