package com.theripe.work.Service.impl;

import com.theripe.work.Service.scoreService;
import com.theripe.work.bean.Score;

import com.theripe.work.dao.scoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/7/13 14:46
 */
@Service
public class scoreServiceImpl implements scoreService {
    @Autowired
    scoreMapper scoreMapper;

    @Override
    public int insert(Score score) {
        int res = scoreMapper.insert(score);
        return res;
    }

    @Override
    public List<Score> selectById(String id) {
        List<Score> res = scoreMapper.selectById(id);
        for (Score re : res) {
            re.toString();
        }
        return res;
    }

    @Override
    public int update(Score score) {
        int res = scoreMapper.update(score);
        return res;
    }
}
