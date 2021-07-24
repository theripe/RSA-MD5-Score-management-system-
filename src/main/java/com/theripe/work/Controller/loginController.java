package com.theripe.work.Controller;

import com.theripe.work.Service.studentService;
import com.theripe.work.Service.teacherService;
import com.theripe.work.bean.Student;
import com.theripe.work.bean.Teacher;
import com.theripe.work.util.RSAUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author TheRipe
 * @create 2021/7/13 12:49
 */
@Controller
@RequestMapping("/login")
public class loginController {
    @Resource
    teacherService teacherService;

    @Resource
    studentService  studentService;

    @GetMapping("/DoS")
    public String doS() {
        return "StudentDo";
    }
    @GetMapping("/DoT")
    public String doT() {
        return "teacherDo";
    }
    @RequestMapping("/loginTeacher")
    public ModelAndView loginT() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("teacherLogin");
        mv.addObject("publicKey", RSAUtil.generateBase64PublicKey());
        System.out.println("这是后端传给前端的公钥" + RSAUtil.generateBase64PublicKey());
        return mv;
    }
    @RequestMapping("/loginStudent")
    public ModelAndView loginS() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("studentLogin");
        mv.addObject("publicKey", RSAUtil.generateBase64PublicKey());
        System.out.println("这是后端传给前端的公钥" + RSAUtil.generateBase64PublicKey());
        return mv;
    }
    @RequestMapping(value = "/loginDoT", method = RequestMethod.POST)
    public String loginT1(@RequestParam("tName") String tno, @RequestParam("tPwd") String password, HttpSession session) {
        System.out.println("------------------结果展示----------------------");
        System.out.println("这是登录的登录名:" + tno);
        System.out.println("这是经前端登录传过来的RSA密码密文串："+password);
        String s = RSAUtil.decryptBase64(password);
        System.out.println("这是后端解密后的密码：" + s);
        Teacher teacher = new Teacher();
        teacher.setTno(tno);
        teacher.setTpassword(s);
        boolean res = teacherService.selectByIdAndPwd(teacher);
        if (res == true) {
            session.setAttribute("isLogin","true");
            return "redirect:/login/DoT";
        } else {
            session.setAttribute("errorMsg","登录错误，请重新登录");
            return "redirect:/login/loginTeacher";
        }

    }

   @RequestMapping(value = "/loginDoS", method = RequestMethod.POST)
    public String loginS2 ( @RequestParam("sName") String sno, @RequestParam("sPwd") String password,HttpSession session)  {

       System.out.println("------------------结果展示----------------------");
       System.out.println("这是登录的登录名:" + sno);
       System.out.println("这是经前端登录传过来的RSA密码密文串："+password);
       String s = RSAUtil.decryptBase64(password);
       System.out.println("这是后端解密后的密码：" + s);
       Student student = new Student();
       student.setSpassword(s);
       student.setSno(sno);
       boolean res = studentService.selectByIdAndPwd(student);
       if (res == true) {
           session.setAttribute("isLogin","true");
           return "redirect:/login/DoS";
       } else {
           session.setAttribute("errorMsg","登录错误，请重新登录");
           return "redirect:/login/loginStudent";
       }
    }
}
