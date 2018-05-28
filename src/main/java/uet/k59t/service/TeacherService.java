package uet.k59t.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.k59t.controller.dto.ConductScoreDTO;
import uet.k59t.controller.dto.StudentDTO;
import uet.k59t.controller.dto.StudentMessageDTO;
import uet.k59t.model.ConductScore;
import uet.k59t.model.Role;
import uet.k59t.model.Student;
import uet.k59t.model.Teacher;
import uet.k59t.repository.ConductScoreRepository;
import uet.k59t.repository.StudentRepository;
import uet.k59t.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ConductScoreRepository conductScoreRepository;

    public List<StudentDTO> listStudents(String token){
        if(teacherRepository.findByToken(token)!= null){
            Teacher teacher = teacherRepository.findByToken(token);
                if(teacher.isScoreAvilable() == true ){
                    List<StudentDTO> studentDTOList = new ArrayList<>();
                    List<Student> listStudentFromDb = studentRepository.findByClassName(teacher.getClassName());
                    for(int i = 0; i < listStudentFromDb.size(); i++){
                        StudentDTO studentDTO = new StudentDTO();
                        ConductScoreDTO conductScoreDTO = new ConductScoreDTO();
                        Student student = listStudentFromDb.get(i);
                        studentDTO.setFirstName(student.getFirstName());
                        studentDTO.setId(student.getId());
                        studentDTO.setLastName(student.getLastName());
                        studentDTO.setMsv(student.getMsv());
                        ConductScore conductScore = conductScoreRepository.findByStudent(student);
                        conductScoreDTO.setCongTacPhuTrach(conductScore.getCongTacPhuTrach());
                        conductScoreDTO.setPhamChatCongDan(conductScore.getPhamChatCongDan());
                        conductScoreDTO.setyThucChapHanh(conductScore.getyThucChapHanh());
                        conductScoreDTO.setyThucHoatDong(conductScore.getyThucHoatDong());
                        conductScoreDTO.setyThucHocTap(conductScore.getyThucHocTap());
                        studentDTO.setConductScoreDTO(conductScoreDTO);
                        studentDTOList.add(studentDTO);
                    }
                    return studentDTOList;
                }
                else throw new NullPointerException("Chua duoc xem diem");
            }
        else throw new NullPointerException("Co van de trong qua trinh dang nhap");
    }

    public void sendMessage(StudentMessageDTO studentMessageDTO, String token){
        if(teacherRepository.findByToken(token) != null){
            Teacher teacher = teacherRepository.findByToken(token);
            Student student = studentRepository.findByClassNameAndRole(teacher.getClassName(), Role.MONITOR);
            student.setMessage(studentMessageDTO.getMessage());
        }
        else throw new NullPointerException("Co van de trong qua trinh dang nhap");
    }
}
