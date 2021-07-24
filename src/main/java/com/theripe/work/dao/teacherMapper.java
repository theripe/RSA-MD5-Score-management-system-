package com.theripe.work.dao;

import com.theripe.work.bean.Teacher;

/**
 * @Author TheRipe
 * @create 2021/7/13 14:46
 */
public interface teacherMapper {
    int insert(Teacher teacher);
    Teacher selectByIdAndPwd(Teacher teacher);
    int updatesPassword(Teacher teacher);
}
