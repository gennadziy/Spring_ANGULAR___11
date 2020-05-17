package Spring_ANGULAR.Spring_ANGULAR.repository;


import Spring_ANGULAR.Spring_ANGULAR.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
