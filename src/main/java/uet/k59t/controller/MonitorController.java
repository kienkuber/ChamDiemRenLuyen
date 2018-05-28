package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uet.k59t.controller.dto.StudentDTO;
import uet.k59t.controller.dto.StudentMessageDTO;
import uet.k59t.model.Student;
import uet.k59t.service.MonitorService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class MonitorController {
    @Autowired
    private MonitorService monitorService;

    @RequestMapping(value = "/scoretable", method = RequestMethod.GET)
    public List<StudentDTO> scoreTable(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return monitorService.showStudentTable(token);}

    @RequestMapping(value = "/sendmessage", method = RequestMethod.POST)
    public void sendMessage(@RequestBody StudentMessageDTO studentMessageDTO, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        monitorService.sendMessage(studentMessageDTO, token);}

    @RequestMapping(value = "/sendscore", method = RequestMethod.GET)
    public void sendScore(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        monitorService.sendScore(token);
    }
}