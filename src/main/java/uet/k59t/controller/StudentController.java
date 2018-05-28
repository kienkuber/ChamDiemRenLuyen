package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uet.k59t.model.ConductScore;
import uet.k59t.service.StudentService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/setscore", method = RequestMethod.POST)
    public void setScore(@RequestBody ConductScore conductScore, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        studentService.setScore(conductScore, token);}
}
