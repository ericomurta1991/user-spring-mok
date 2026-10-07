package br.com.projeto.api_rest.mappers;

import br.com.projeto.api_rest.dto.UserDTO;
import br.com.projeto.api_rest.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDTO toUserDTO(User user)  {
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public static User toEntity(UserDTO dto){
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        return user;
    }
}
