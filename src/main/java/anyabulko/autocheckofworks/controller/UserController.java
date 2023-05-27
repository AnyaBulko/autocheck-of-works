package anyabulko.autocheckofworks.controller;

import anyabulko.autocheckofworks.domain.Role;
import anyabulko.autocheckofworks.domain.User;
import anyabulko.autocheckofworks.exception.UserNotFoundException;
import anyabulko.autocheckofworks.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> list() {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable Long id) throws UserNotFoundException {
        User user = userRepo.findById(id).orElseThrow( () -> new UserNotFoundException(id));
        return user;
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        user.setRoles(Collections.singleton(Role.ADMIN));
        user.setRegistrationDate(LocalDateTime.now());
        return userRepo.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") User userFromDB, @RequestBody User user) {
        BeanUtils.copyProperties(user,userFromDB,"id");
        return userRepo.save(userFromDB);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") User user) {
        userRepo.delete(user);
    }
}
