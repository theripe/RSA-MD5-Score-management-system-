package com.theripe.work.Controller;

import com.theripe.work.Service.scoreService;
import com.theripe.work.Service.studentService;
import com.theripe.work.Service.teacherService;
import com.theripe.work.bean.Student;
import com.theripe.work.bean.Teacher;
import com.theripe.work.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author TheRipe
 * @create 2021/7/15 10:38
 */
//这是注册账号的容器
@Controller
@RequestMapping("/regist")
public class registController {

    @Resource
    scoreService scoreService;
    @Resource
    studentService studentService;
    @Resource
    teacherService teacherService;
    @GetMapping("/student")
    public String zhuceStudent() {
        return "registStudent";
    }

    @GetMapping("/teacher")
    public String zhuceTeacher() {
        return "registTeacher";
    }

    @ResponseBody
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String zhuceS(@RequestParam("name") String name,@RequestParam("sno") String sno, @RequestParam("spassword") String spassword ) {
        Student s = new Student();
        s.setSpassword(spassword);
        s.setName(name);
        s.setSno(sno);
        studentService.insert(s);
        return  null;


    }

    @ResponseBody
    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public String zhuceT(@RequestParam("name") String name,@RequestParam("tno") String tno, @RequestParam("tpassword") String tpassword) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setTno(tno);
        teacher.setTpassword(tpassword);
        teacherService.insert(teacher);
        return null;
    }
}
