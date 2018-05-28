package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uet.k59t.model.ConductScore;
import uet.k59t.model.Student;

@Repository
public interface ConductScoreRepository extends CrudRepository<ConductScore, Long> {
    ConductScore findByStudent(Student student);
}
