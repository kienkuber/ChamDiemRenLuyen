package uet.k59t.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.k59t.model.ConductScore;
import uet.k59t.model.Student;
import uet.k59t.repository.ConductScoreRepository;
import uet.k59t.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ConductScoreRepository conductScoreRepository;

    public void setScore(ConductScore conductScore, String token) {
        if(studentRepository.findByToken(token) != null){
            Student a = studentRepository.findByToken(token);
            ConductScore b = conductScoreRepository.findByStudent(a);
            b.setCongTacPhuTrach(conductScore.getCongTacPhuTrach());
            b.setPhamChatCongDan(conductScore.getPhamChatCongDan());
            b.setyThucChapHanh(conductScore.getyThucChapHanh());
            b.setyThucHoatDong(conductScore.getyThucHoatDong());
            b.setyThucHocTap(conductScore.getyThucHocTap());
            conductScoreRepository.save(b);
        }
        else throw new NullPointerException("co loi xay ra");
    }

}

