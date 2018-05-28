package uet.k59t.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.k59t.controller.dto.UserDTO;
import uet.k59t.model.Student;
import uet.k59t.model.Teacher;
import uet.k59t.repository.StudentRepository;
import uet.k59t.repository.TeacherRepository;

import java.util.UUID;

@Service
public class LoginService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

    public UserDTO login(UserDTO userDTO) {
        if(studentRepository.findByMsv(userDTO.getUserName()) != null){
            Student a = studentRepository.findByMsv(userDTO.getUserName());
            if(a.getPassword().equals(userDTO.getPassword())){
                if(a.getToken() == null){
                    a.setToken(UUID.randomUUID().toString());
                }
                a = studentRepository.save(a);
                UserDTO result = new UserDTO();
                result.setUserName(a.getMsv());
                result.setPassword(a.getPassword());
                result.setToken(a.getToken());
                result.setRole(a.getRole());
                return result;
            }
        }
        else if(teacherRepository.findByUsername(userDTO.getUserName()) != null){
            Teacher a = teacherRepository.findByUsername(userDTO.getUserName());
            if(a.getPassword().equals(userDTO.getPassword())){
                if(a.getToken() == null){
                    a.setToken(UUID.randomUUID().toString());
                }
                a = teacherRepository.save(a);
                UserDTO result = new UserDTO();
                result.setUserName(a.getUsername());
                result.setPassword(a.getPassword());
                result.setRole(a.getRole());
                result.setToken(a.getToken());
                return result;
            }
        }

        else{
            throw new NullPointerException("Sai username hoac password");
        }
        return null;
    }

    public void logout(String token) {
        if(teacherRepository.findByToken(token) != null){
            Teacher teacher = teacherRepository.findByToken(token);
            teacher.setToken(null);
            teacherRepository.save(teacher);
        }
        else if(studentRepository.findByToken(token) != null){
            Student student = studentRepository.findByToken(token);
            student.setToken(null);
            studentRepository.save(student);
        }
    }
}