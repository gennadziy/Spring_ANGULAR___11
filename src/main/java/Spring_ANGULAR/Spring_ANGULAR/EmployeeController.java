package Spring_ANGULAR.Spring_ANGULAR;


import Spring_ANGULAR.Spring_ANGULAR.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/springboot-crud-rest/api/v1")
public class EmployeeController {

	@Autowired
	private PlanetDao planetDao;


	@GetMapping("/planets")
	public List<Planets> getAllPlanets() {
		return planetDao.findAll ();}

	@GetMapping("/planets/{id}")
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
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		planetDao.delete(planet);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}



}
