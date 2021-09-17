package com.example.rabittesttask.advertisement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdvertisementService {
    private AdvertisementRepository advertisementRepository;


    public List<AdvertisementDTO> getAddsFromDatabase() {
        List<Advertisement> advertisements = advertisementRepository.findAll();
        return advertisements
                .stream()
                .map(n -> new AdvertisementDTO(n.getId(), n.getTitle(), n.getUser().getFullName()))
                .toList();
    }
}
