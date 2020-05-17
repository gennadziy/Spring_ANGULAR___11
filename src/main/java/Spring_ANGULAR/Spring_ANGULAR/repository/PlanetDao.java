package Spring_ANGULAR.Spring_ANGULAR.repository;


import Spring_ANGULAR.Spring_ANGULAR.Planets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
@Author Gennadziy GITHUB/gennadziy
Class name: PlanetDao
Date: 2020-05-13
Time: 20:30
*/
@Repository
public interface  PlanetDao extends JpaRepository<Planets, Integer> {
}