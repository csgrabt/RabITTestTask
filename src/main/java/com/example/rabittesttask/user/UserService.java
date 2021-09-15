package com.example.rabittesttask.user;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
