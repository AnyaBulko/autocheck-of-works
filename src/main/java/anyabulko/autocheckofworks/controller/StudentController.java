package anyabulko.autocheckofworks.controller;

import anyabulko.autocheckofworks.domain.Student;
import anyabulko.autocheckofworks.domain.User;
import anyabulko.autocheckofworks.domain.Views;
import anyabulko.autocheckofworks.repo.StudentRepo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private final StudentRepo studentRepo;

    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('TEACHER')")
    @JsonView(Views.idName.class)
    public List<Student> list(@AuthenticationPrincipal User user) {
        return  studentRepo.findByTeacher_Id(user.getId());
    }
}
