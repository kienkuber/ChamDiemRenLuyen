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

import javax.validation.constraints.Null;
import java.util.*;

@Service
public class MonitorService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ConductScoreRepository conductScoreRepository;

    //Lop truong kiem tra diem cua tung sinh vien
    public List<StudentDTO> showStudentTable(String token) {
        if(studentRepository.findByToken(token) != null){
            Student a = studentRepository.findByToken(token);
            if(a.getRole() == Role.MONITOR){
                List<StudentDTO> studentDTOList = new ArrayList<>();
                List<Student> listStudentFromDb = studentRepository.findByClassName(a.getClassName());
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
            else throw new NullPointerException("Ban khong phai lop truong");
        }
        else throw new NullPointerException("Co van de trong qua trinh dang nhap");
    }


//Lop truong gui list score cho thay co van
    public void sendScore(String token){
        if(studentRepository.findByToken(token) != null){
            Student student = studentRepository.findByToken(token);
            if(student.getRole() == Role.MONITOR){
                Teacher teacher = teacherRepository.findByClassName(student.getClassName());
                teacher.setScoreAvilable(true);
                teacherRepository.save(teacher);
            }
        }
        else throw new NullPointerException("Co van de trong qua trinh dang nhap");
    }

    //gui thong bao cho sinh vien
    public void sendMessage(StudentMessageDTO studentMessageDTO, String token){
        if(studentRepository.findByToken(token) != null){
            Student monitor = studentRepository.findByToken(token);
            if(monitor.getRole() == Role.MONITOR){
                Student student = studentRepository.findOne(studentMessageDTO.getId());
                if(student.getMonitor() == monitor) {
                    student.setMessage(studentMessageDTO.getMessage());
                }
                else throw new NullPointerException("Ban khong co quyen gui tin cho sinh vien nay");
            }
            else throw new NullPointerException("Ban khong phai lop truong");
        }
        else throw new NullPointerException("Co van de trong ua trinh dang nhap");
    }
}
