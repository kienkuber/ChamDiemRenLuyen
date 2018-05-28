package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uet.k59t.controller.dto.StudentDTO;
import uet.k59t.model.Role;
import uet.k59t.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
    Student findByMsv(String username);
    Student findByToken(String token);
    List<Student> findByClassName(String classname);
    Student findByClassNameAndRole(String classmname, Role role);
}
