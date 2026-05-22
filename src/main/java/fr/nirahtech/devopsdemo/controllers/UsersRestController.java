package fr.nirahtech.devopsdemo.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.nirahtech.devopsdemo.domain.User;
import fr.nirahtech.devopsdemo.repositories.UsersRepository;

@RestController
@RequestMapping("/users")
public class UsersRestController {

    private final UsersRepository usersRepository;

    public UsersRestController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("")
    public Page<User> findAllUsers(Pageable pageable) {
        return this.usersRepository.findAll(pageable);
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return this.usersRepository.save(user);
    }
}
