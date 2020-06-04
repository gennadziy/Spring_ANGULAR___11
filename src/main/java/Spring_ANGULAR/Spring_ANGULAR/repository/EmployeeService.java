package Spring_ANGULAR.Spring_ANGULAR.repository;


import Spring_ANGULAR.Spring_ANGULAR.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService  {

    List<Employee> findPaginated(int pageNo, int pageSize);

}
