package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uet.k59t.controller.dto.StudentDTO;
import uet.k59t.controller.dto.StudentMessageDTO;
import uet.k59t.model.Student;
import uet.k59t.service.TeacherService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/teachertable", method = RequestMethod.GET)
    public List<StudentDTO> teacherTable(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return teacherService.listStudents(token);
    }

    @RequestMapping(value = "/teachermessage", method = RequestMethod.POST)
    public void sendMessage(@RequestBody StudentMessageDTO studentMessageDTO, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        teacherService.sendMessage(studentMessageDTO, token);
    }

}
