package Spring_ANGULAR.Spring_ANGULAR.repository;


import Spring_ANGULAR.Spring_ANGULAR.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeService  {

    List<Employee> findPaginated(int pageNo, int pageSize);

}
