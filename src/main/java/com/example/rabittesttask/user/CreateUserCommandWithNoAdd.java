package com.example.rabittesttask.user;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Tag(name = "Create a new User")

public class CreateUserCommandWithNoAdd {
    @Schema(description = "Name of the new User", example = "John Doe")
    private String fullName;
}
