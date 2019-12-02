package pl.javaNotFoundException.jpaAuditing.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javaNotFoundException.jpaAuditing.dto.UserDto;
import pl.javaNotFoundException.jpaAuditing.service.UserService;

import java.util.List;

@RestController @RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto newUser = userService.createUser(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/users")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        UserDto newUser = userService.updateUser(userDto);

        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @DeleteMapping("/users")
    public ResponseEntity<Void> deleteUser(@RequestBody UserDto userDto) {
        userService.deleteUser(userDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
