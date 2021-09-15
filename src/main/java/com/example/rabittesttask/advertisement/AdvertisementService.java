package com.example.rabittesttask.advertisement;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdvertisementService {
    private AdvertisementRepository advertisementRepository;
    private ModelMapper modelMapper;
}
