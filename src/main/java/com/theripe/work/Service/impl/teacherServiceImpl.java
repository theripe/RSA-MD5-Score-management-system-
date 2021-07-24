package com.theripe.work.Service.impl;

import com.theripe.work.Service.teacherService;
import com.theripe.work.bean.Teacher;
import com.theripe.work.dao.teacherMapper;
import com.theripe.work.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author TheRipe
 * @create 2021/7/13 14:47
 */
@Service
public class teacherServiceImpl implements teacherService {
   @Autowired
    teacherMapper teacherMapper;
    @Override
    public int insert(Teacher teacher) {
      String password = teacher.getTpassword();
      //进数据库时密码使用MD5加密
      String newPassword = MD5Util.MD5Encode(password,"UTF-8");
      teacher.setTpassword(newPassword);
        int res = teacherMapper.insert(teacher);
        return res;
    }

    @Override
    public boolean selectByIdAndPwd(Teacher teacher) {
        String tpassword = teacher.getTpassword();
        //加密后去数据库查询密码
        String newPassword = MD5Util.MD5Encode(tpassword,"UTF-8");
        teacher.setTpassword(newPassword);
        if ( teacherMapper.selectByIdAndPwd(teacher) == null) {
            return false;
        }
        return true;
    }

    @Override
    public int update(Teacher teacher) {
        int i = teacherMapper.updatesPassword(teacher);
        return i;
    }
}
