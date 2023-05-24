package anyabulko.autocheckofworks.controller;

import anyabulko.autocheckofworks.domain.User;
import anyabulko.autocheckofworks.exception.UserNotFoundException;
import anyabulko.autocheckofworks.repo.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
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
        return userRepo.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User updateUser = userRepo.getReferenceById(id); //
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());
        return userRepo.save(updateUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") User user) {
        userRepo.delete(user);
    }
}
