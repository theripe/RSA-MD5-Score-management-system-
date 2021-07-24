package com.theripe.work.Service;

import com.theripe.work.bean.Student;

/**
 * @Author TheRipe
 * @create 2021/7/13 14:46
 */
public interface studentService {
    int insert(Student student);
    boolean selectByIdAndPwd(Student student);
    int update(Student student);
}
