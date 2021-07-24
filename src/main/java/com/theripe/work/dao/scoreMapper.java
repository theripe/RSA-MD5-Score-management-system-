package com.theripe.work.dao;

import com.theripe.work.bean.Score;

import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/7/13 14:46
 */
public interface scoreMapper {
    int insert(Score score);
    List<Score> selectById(String id);
    int update(Score score);
}
