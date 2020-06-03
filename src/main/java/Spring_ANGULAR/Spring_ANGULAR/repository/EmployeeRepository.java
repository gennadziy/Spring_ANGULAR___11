package Spring_ANGULAR.Spring_ANGULAR.repository;


import Spring_ANGULAR.Spring_ANGULAR.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> , PagingAndSortingRepository<Employee, Long> {
    @Query(value = "SELECT u FROM Employee u WHERE u.emailId like 'geniy@tut.by'")
    List<Employee> findAllEmpl( Sort sort);

//    @Query(value = "SELECT u FROM Employee u ")
//    List<Employee> findAllEmpl1( double price, Pageable pageable);

}
