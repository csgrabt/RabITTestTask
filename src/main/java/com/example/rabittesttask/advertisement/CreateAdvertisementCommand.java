package com.example.rabittesttask.advertisement;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdvertisementCommand {

    private Long userId;
    private String title;


}
