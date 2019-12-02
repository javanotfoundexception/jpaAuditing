package pl.javaNotFoundException.jpaAuditing.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javaNotFoundException.jpaAuditing.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
