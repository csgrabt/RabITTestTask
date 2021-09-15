package com.example.rabittesttask;

import com.example.rabittesttask.advertisement.Advertisement;
import com.example.rabittesttask.advertisement.AdvertisementDTO;
import com.example.rabittesttask.advertisement.AdvertisementService;
import com.example.rabittesttask.advertisement.CreateAdvertisementCommand;
import com.example.rabittesttask.user.CreateUserCommandWithNoAdd;
import com.example.rabittesttask.user.UserDTO;
import com.example.rabittesttask.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class AdvertisementControllerRestTemplateIT {

    @Autowired
    TestRestTemplate template;
    @Autowired
    AdvertisementService advertisementService;

    @Test
    void listOfTheAdds() {

        UserDTO user1 = template.postForObject("/api/users", new CreateUserCommandWithNoAdd("John Doe"), UserDTO.class);
        UserDTO user2 = template.postForObject("/api/users", new CreateUserCommandWithNoAdd("Jack Doe"), UserDTO.class);

        CreateAdvertisementCommand advertisementCommand1 = new CreateAdvertisementCommand(user1.getId(), "Almavirág hírdetés");
        template.postForObject("/api/users/advertisement", advertisementCommand1, AdvertisementDTO.class);

        CreateAdvertisementCommand advertisementCommand2 = new CreateAdvertisementCommand(user2.getId(), "Almavirág hírdetés");
        template.postForObject("/api/users/advertisement", advertisementCommand2, AdvertisementDTO.class);


        List<AdvertisementDTO> list = template.exchange("/api/advertisements", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<AdvertisementDTO>>() {
                }).getBody();

      //  assertThat(list)
      //          .extracting(AdvertisementDTO::getUserName)
      //          .containsExactly("John Doe", "Jack Doe");
    }

}
