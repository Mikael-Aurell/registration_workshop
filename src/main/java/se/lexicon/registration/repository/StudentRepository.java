package se.lexicon.registration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.registration.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

}
