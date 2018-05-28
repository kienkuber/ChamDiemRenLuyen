package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uet.k59t.model.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    Teacher findByUsername(String username);
    Teacher findByToken(String token);
    Teacher findByClassName(String classname);
}
