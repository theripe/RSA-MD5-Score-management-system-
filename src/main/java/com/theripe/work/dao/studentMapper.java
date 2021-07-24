package com.theripe.work.dao;

import com.theripe.work.bean.Student;

/**
 * @Author TheRipe
 * @create 2021/7/13 14:46
 */
public interface studentMapper {
    int insert(Student student);
    Student selectByIdAndPwd(Student student);
    int updatesPassword(Student student);
}
