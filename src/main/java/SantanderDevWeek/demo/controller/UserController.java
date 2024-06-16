package SantanderDevWeek.demo.controller;


import SantanderDevWeek.demo.model.User;
import SantanderDevWeek.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    ;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        var usercreated = userService.create(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(usercreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(usercreated);
    }
}
