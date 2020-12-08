package Spring_ANGULAR.Spring_ANGULAR.repository;

import Spring_ANGULAR.Spring_ANGULAR.model.Employee;
import Spring_ANGULAR.Spring_ANGULAR.model.Planets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@Service
public class PlanetServImpl implements PlanetService {

    @Autowired
    private PlanetDao planetDao;
    @Override
    @Cacheable("planets_________")
    public List<Planets> all () throws InterruptedException {
        Thread.sleep ( 5000 );
        return planetDao.findAll ();
    }

    @Override
    @Cacheable("planets1")
    public List <Planets> allSort () throws InterruptedException {
        Thread.sleep ( 5000 );
        return planetDao.findSortPlanet1 ( );
    }


}

