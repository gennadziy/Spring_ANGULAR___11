package Spring_ANGULAR.Spring_ANGULAR.repository;

import Spring_ANGULAR.Spring_ANGULAR.model.Planets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PlanetServImpl implements PlanetService {

    @Autowired
    private PlanetDao planetDao;
    @Override
    @Cacheable("planets")
    public List<Planets> all () throws InterruptedException {
        Thread.sleep ( 3000 );
        return planetDao.findAll ();
    }
}

