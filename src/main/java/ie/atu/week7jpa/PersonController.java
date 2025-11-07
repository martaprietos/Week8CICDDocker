package ie.atu.week7jpa;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService service;
    public PersonController(PersonService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@Valid @RequestBody Person person) {
        return service.create(person);
    }

    @GetMapping
    public List<Person> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Person byEmployeeId(@PathVariable String id) {
        return service.findByEmployeeId(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestParam String email) {//use id to find person, take in new email value
        service.update(id, email);
    }
}
