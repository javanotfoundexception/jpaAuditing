package pl.javaNotFoundException.jpaAuditing.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.javaNotFoundException.jpaAuditing.entity.User;

@Getter
@NoArgsConstructor
public class UserDto {

    private Long id;
    private Integer version;
    private String name;
    private String surname;
    private String email;

    public UserDto(User user) {
        this.id = user.getId();
        this.version = user.getVersion();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
    }
}
