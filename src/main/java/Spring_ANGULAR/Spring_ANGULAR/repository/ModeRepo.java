package Spring_ANGULAR.Spring_ANGULAR.repository;

import Spring_ANGULAR.Spring_ANGULAR.model.Mode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeRepo extends JpaRepository<Mode, Integer> {
}
