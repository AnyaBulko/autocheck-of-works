package anyabulko.autocheckofworks.controller;

import anyabulko.autocheckofworks.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    private final UserRepo userRepo;

    public MainController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("users",userRepo.findAll());
        return "index";
    }
}
