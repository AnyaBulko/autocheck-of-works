package anyabulko.autocheckofworks.repo;

import anyabulko.autocheckofworks.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Long> {

    List<Student> findByTeacher_Id(Long teacher);

}
