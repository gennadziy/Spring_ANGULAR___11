package Spring_ANGULAR.Spring_ANGULAR.repository;

import Spring_ANGULAR.Spring_ANGULAR.model.Planets;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlanetDao extends JpaRepository<Planets, Integer>, PagingAndSortingRepository<Planets, Integer> {
        @Query(value = "SELECT u FROM Planets u WHERE u.name_planet like 'jupiter' ")
        List<Planets> findSortPlanet(Sort sort);

    @Query(value = "SELECT t FROM Planets t WHERE t.name_planet like t.name_planet order by t.name_planet asc ")
    List<Planets> findSortPlanet1();
}
