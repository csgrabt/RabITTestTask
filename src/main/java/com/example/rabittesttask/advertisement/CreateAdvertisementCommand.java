package com.example.rabittesttask.advertisement;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdvertisementCommand {
    @NotBlank
    private Long userId;
    @NotBlank
    private String title;


}
