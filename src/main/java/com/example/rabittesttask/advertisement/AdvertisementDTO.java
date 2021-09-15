package com.example.rabittesttask.advertisement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdvertisementDTO {
    private Long id;
    private String title;
    private Long userId;
}
