package anyabulko.autocheckofworks.repo;

import anyabulko.autocheckofworks.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
