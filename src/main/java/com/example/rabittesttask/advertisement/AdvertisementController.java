package com.example.rabittesttask.advertisement;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/advertisement")
@RestController
@AllArgsConstructor
@Tag(name = "Operations on Advertisement")
public class AdvertisementController {

    private AdvertisementService advertisementService;
}
