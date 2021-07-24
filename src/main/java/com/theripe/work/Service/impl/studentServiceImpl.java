package com.theripe.work.Service.impl;


import com.theripe.work.Service.studentService;
import com.theripe.work.bean.Student;
import com.theripe.work.dao.studentMapper;
import com.theripe.work.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author TheRipe
 * @create 2021/7/13 14:47
 */
@Service
public class studentServiceImpl implements studentService {
    @Autowired
    studentMapper studentMapper;
    @Override
    public int insert(Student student) {
        String spassword = student.getSpassword();
        String newPassword = MD5Util.MD5Encode(spassword,"UTF-8");
        student.setSpassword(newPassword);
        int res = studentMapper.insert(student);
        return res;
    }

    @Override
    public boolean selectByIdAndPwd(Student student) {
        String spassword = student.getSpassword();
        String newPassword = MD5Util.MD5Encode(spassword,"UTF-8");
        student.setSpassword(newPassword);
        if (studentMapper.selectByIdAndPwd(student)== null) {
            return false;
        }
        return true;
    }

    @Override
    public int update(Student student) {
        int res = studentMapper.updatesPassword(student);
        return res;
    }
}
