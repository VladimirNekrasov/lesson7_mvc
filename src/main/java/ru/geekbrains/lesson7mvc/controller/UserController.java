package ru.geekbrains.lesson7mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.lesson7mvc.model.User;
import ru.geekbrains.lesson7mvc.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/search")
    public User getUserById(@RequestParam String name) {
        return userRepository.findByName(name).get();
    }

    @GetMapping()
    public List<User> showAllUsers() {
        return userRepository.findAll();
    }




}
