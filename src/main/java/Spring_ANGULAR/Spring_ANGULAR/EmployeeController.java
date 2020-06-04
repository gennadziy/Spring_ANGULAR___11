package Spring_ANGULAR.Spring_ANGULAR;


import Spring_ANGULAR.Spring_ANGULAR.exception.ResourceNotFoundException;
import Spring_ANGULAR.Spring_ANGULAR.model.Autoss;
import Spring_ANGULAR.Spring_ANGULAR.model.Employee;
import Spring_ANGULAR.Spring_ANGULAR.model.Mode;
import Spring_ANGULAR.Spring_ANGULAR.model.Planets;
import Spring_ANGULAR.Spring_ANGULAR.repository.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Api(value = "Main REST Controller", tags = {"main-controller"})
@RestController
@RequestMapping("/springboot-crud-rest/api/v1")
@Produces( {MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})

public class EmployeeController  {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModeRepo modeRepo;
	@Autowired
	private AutoDao autoDao;
	@Autowired(required=true)
	private PlanetDao planetDao;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private PlanetService planetService;


	@GetMapping("/empl")
	public List<Employee> getAllSort() {

		return employeeRepository.findAllEmpl ( JpaSort.unsafe("LENGTH(emailId)") );
	}

	@GetMapping("/empl1/{pageNo}/{pageSize}")
	public List<Employee> findPaginated(@PathVariable int pageNo,
										@PathVariable int pageSize) {
		return employeeService.findPaginated(pageNo, pageSize);
	}


	@GetMapping("/planets")
	public List<Planets> getAllPlanets() throws InterruptedException {

		return planetService.all ();}

	@GetMapping("/planets/{id}")
	@Cacheable("planet")
	public ResponseEntity<Planets> getPlanetById( @PathVariable(value = "id") int id)
			throws ResourceNotFoundException {
		Planets planets = planetDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Planet not found for this id :: " + id));
		return ResponseEntity.ok().body(planets);
	}

	@PostMapping("/planets")
	public Planets createPlanet(@Valid @RequestBody Planets planets) {
		return planetDao.save(planets);
	}

	@PutMapping("/planets/{id}")
	public ResponseEntity<Planets> updatePlanet( @PathVariable(value = "id") int id,
                                                 @Valid @RequestBody Planets planetDetails) throws ResourceNotFoundException {
		Planets planet = planetDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Planet not found for this id :: " + id));
		planet.setId(planetDetails.getId());
		planet.setName_planet(planetDetails.getName_planet());
		planet.setPlanet_type (planetDetails.getPlanet_type ());
		planet.setUrl_img(planetDetails.getUrl_img());
		planet.setDistance (planetDetails.getDistance ());
		planet.setOne_Way_Light_Time (planetDetails.getOne_Way_Light_Time ());
		planet.setUrl_img(planetDetails.getUrl_img());
		planet.setLength_of_Year (planetDetails.getLength_of_Year ());
		planet.setDescr (planetDetails.getDescr ());
		final Planets updatedEmployee = planetDao.save(planet);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/planets/{id}")
	public Map<String, Boolean> deletePlanet(@PathVariable(value = "id") int id)
			throws ResourceNotFoundException {
		Planets planet = planetDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("PLanet not found for this id :: " + id));
		planetDao.delete(planet);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@ApiIgnore
	@GetMapping("/autos")
	public List<Autoss> getAllAutos() {
		return autoDao.findAll();
	}
	@ApiIgnore
	@GetMapping("/modes")
	public List<Mode> getAllMode() {
		return modeRepo.findAll();
	}

	@GetMapping("/employees")
    public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
												   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}

