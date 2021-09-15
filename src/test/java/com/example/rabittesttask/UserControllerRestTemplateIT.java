package com.example.rabittesttask;


import com.example.rabittesttask.advertisement.AdvertisementDTO;
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
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Sql(statements =
class UserControllerRestTemplateIT {

    @Autowired
    TestRestTemplate template;
    @Autowired
    UserService userService;

    @Test
    void createUser() {

        CreateUserCommandWithNoAdd inputCommand = new CreateUserCommandWithNoAdd("John Doe");
        UserDTO user = template.postForObject("/api/users", inputCommand, UserDTO.class);
        assertEquals("John Doe", user.getFullName());


    }

    @Test
    void listOfTheUsers() {

        template.postForObject("/api/users", new CreateUserCommandWithNoAdd("John Doe"), UserDTO.class);
        template.postForObject("/api/users", new CreateUserCommandWithNoAdd("Jack Doe"), UserDTO.class);


        List<UserDTO> list = template.exchange("/api/users", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<UserDTO>>() {
                }).getBody();

        assertThat(list)
                .extracting(UserDTO::getFullName)
                .containsExactly("John Doe", "Jack Doe");
    }

    @Test
    void createAdvertisement() {

        CreateUserCommandWithNoAdd inputCommand = new CreateUserCommandWithNoAdd("John Doe");
        UserDTO user = template.postForObject("/api/users", inputCommand, UserDTO.class);

        CreateAdvertisementCommand advertisementCommand = new CreateAdvertisementCommand(user.getId(), "Almavirág hírdetés");

        AdvertisementDTO advertisementDTO = template.postForObject("/api/users/advertisement", advertisementCommand, AdvertisementDTO.class);

        assertEquals(user.getFullName(), advertisementDTO.getUserName());
        assertEquals("Almavirág hírdetés", advertisementCommand.getTitle());


    }


}
