package br.com.projeto.api_rest.services;

import br.com.projeto.api_rest.entities.User;
import br.com.projeto.api_rest.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario não encontrado!"));
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User updateById(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario não encontrado!"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
        userRepository.deleteById(id);
    }
}
