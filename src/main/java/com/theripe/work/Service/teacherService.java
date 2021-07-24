package com.theripe.work.Service;

import com.theripe.work.bean.Teacher;

/**
 * @Author TheRipe
 * @create 2021/7/13 14:46
 */
public interface teacherService {
    int insert(Teacher teacher);
    boolean selectByIdAndPwd(Teacher teacher);
    int update(Teacher teacher);
}
