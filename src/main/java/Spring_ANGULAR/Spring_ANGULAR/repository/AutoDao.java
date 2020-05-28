package Spring_ANGULAR.Spring_ANGULAR.repository;

import Spring_ANGULAR.Spring_ANGULAR.Autoss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/*
@Author Gennadziy GITHUB/gennadziy
Class name: AutoDao
Date: 2020-03-22
Time: 17:22
*/
@Repository
@Component(value = "auto")
public interface AutoDao extends JpaRepository<Autoss, Integer> {
}
