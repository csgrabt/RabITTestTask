package com.example.rabittesttask.user;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/users")
@RestController
@AllArgsConstructor
@Tag(name = "Operations on Users")
public class UserController {

    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates an User")
    @ApiResponse(responseCode = "201", description = "User has been created")
    public UserDTO createUser(@Valid @RequestBody CreateUserCommandWithNoAdd command) {
        return userService.createUserWithNoAdd(command);
    }


}
