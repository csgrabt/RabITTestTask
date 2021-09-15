package com.example.rabittesttask.user;

import com.example.rabittesttask.advertisement.Advertisement;
import com.example.rabittesttask.advertisement.AdvertisementDTO;
import com.example.rabittesttask.advertisement.CreateAdvertisementCommand;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
public class UserService {
    private ModelMapper modelMapper;
    private UserRepository userRepository;

    public UserDTO createUserWithNoAdd(CreateUserCommandWithNoAdd command) {
        User user = new User(command.getFullName());
        userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);

    }

    public List<UserDTO> getUsersFromDatabase() {
        List<User> usersFromDataBase = userRepository.findAll();
        return usersFromDataBase
                .stream()
                .map(n -> modelMapper.map(n, UserDTO.class))
                .toList();
    }


    @Transactional
    public AdvertisementDTO createAdvertisement(CreateAdvertisementCommand command) {

        User user = userRepository.findById(command.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        System.out.println(user);
        Advertisement advertisement = new Advertisement(command.getTitle());
        System.out.println(advertisement);
        advertisement.setUser(user);
        return new AdvertisementDTO(advertisement.getId(), advertisement.getTitle(), user.getFullName());

    }
}
