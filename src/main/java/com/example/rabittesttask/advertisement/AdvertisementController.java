package com.example.rabittesttask.advertisement;


import com.example.rabittesttask.user.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/advertisements")
@RestController
@AllArgsConstructor
@Tag(name = "Operations on Advertisement")
public class AdvertisementController {

    private AdvertisementService advertisementService;

    @GetMapping
    @Operation(summary = "Gives back the list of Adds")
    public List<AdvertisementDTO> usersFromDatabase() {
        return advertisementService.getAddsFromDatabase();
    }

}
