package pl.javaNotFoundException.jpaAuditing.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.javaNotFoundException.jpaAuditing.dto.UserDto;
import pl.javaNotFoundException.jpaAuditing.entity.User;
import pl.javaNotFoundException.jpaAuditing.respository.UserRepository;

import javax.persistence.OptimisticLockException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto createUser(UserDto userDto) {
        User user = assignFieldsToUser(new User(), userDto);
        User userAfterSave = userRepository.save(user);

        return new UserDto(userAfterSave);
    }

    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.getOne(userDto.getId());

        if (!user.getVersion().equals(userDto.getVersion()))
            throw new OptimisticLockException();

        User userAfterUpdate = userRepository.save(assignFieldsToUser(user, userDto));
        return new UserDto(userAfterUpdate);
    }

    public void deleteUser(UserDto userDto) {
        User user = userRepository.getOne(userDto.getId());

        if (!user.getVersion().equals(userDto.getVersion()))
            throw new OptimisticLockException();

        userRepository.delete(user);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    private User assignFieldsToUser(User user, UserDto userDto) {
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());

        return user;
    }
}
