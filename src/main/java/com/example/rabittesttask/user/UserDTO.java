package com.example.rabittesttask.user;

import com.example.rabittesttask.advertisement.Advertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private Long id;
    private String fullName;
    private List<Advertisement> advertisements;
}
