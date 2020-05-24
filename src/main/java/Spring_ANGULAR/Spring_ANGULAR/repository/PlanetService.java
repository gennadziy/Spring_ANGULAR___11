package Spring_ANGULAR.Spring_ANGULAR.repository;

import Spring_ANGULAR.Spring_ANGULAR.Planets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
@Author Gennadziy GITHUB/gennadziy
Class name: PlanetDao
Date: 2020-05-13
Time: 20:30
*/
public interface PlanetService {

    List<Planets> all() throws InterruptedException;
}
