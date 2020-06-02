package Spring_ANGULAR.Spring_ANGULAR.repository;

import Spring_ANGULAR.Spring_ANGULAR.model.Planets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/*
@Author Gennadziy GITHUB/gennadziy
Class name: PlanetServImpl
Date: 2020-05-24
Time: 10:58
*/
@Service
public class PlanetServImpl implements PlanetService {

    @Autowired
    private PlanetDao planetDao;
    @Override
    @Cacheable("book")
    public List<Planets> all () throws InterruptedException {
        Thread.sleep ( 5000 );
        return planetDao.findAll ();
    }
}
