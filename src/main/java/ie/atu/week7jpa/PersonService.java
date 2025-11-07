package ie.atu.week7jpa;

import org.springframework.stereotype.Service;

import java.security.cert.Extension;
import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repo;
    public PersonService(PersonRepository repo) { this.repo = repo; }
    public Person create(Person p) { return repo.save(p); }
    public List<Person> findAll() { return repo.findAll(); }
    public Person findByEmployeeId(String id) {
        return repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
    }

    public Person delete(String id) {
        Person person = repo.findByEmployeeId(id).orElseThrow(() -> new IllegalArgumentException("Person not found"));;
        repo.delete(person);//delete person with corresponding id
        return person;
    }

    public Person update(String id, String email) {
        Person person = repo.findByEmployeeId(id).orElseThrow(() -> new IllegalArgumentException("Person not found"));;
        person.setEmail(email);//use setter to change email
        repo.save(person);//put person back into database
        return person;
    }
}
