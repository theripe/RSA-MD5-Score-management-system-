package com.theripe.work.Controller;

import com.theripe.work.Service.scoreService;
import com.theripe.work.bean.Score;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/7/15 18:57
 */
@RestController
@RequestMapping("/do")
public class doController {
    @Resource
    scoreService scoreService;
    @RequestMapping("/selectS")
    public List<Score> selectS(@RequestParam("sno") String sno) {
        List<Score> res = scoreService.selectById(sno);
        return res;
    }

    @RequestMapping("/selectI")
    public String selectI(@RequestParam("ino") String sno, @RequestParam("icourse") String course, @RequestParam("iscore") Integer score) {
        Score score1 = new Score();
        score1.setScore(score);
        score1.setCourse(course);
        score1.setSno(sno);
        int i = scoreService.insert(score1);
        if (i == 0) {
            return "增加失败";
        } else {
            return "增加成功";
        }
    }


    @RequestMapping("/selectU")
    public String selectU(@RequestParam("uno") String sno, @RequestParam("ucourse") String course, @RequestParam("uscore") Integer score) {
        Score score1 = new Score();
        score1.setScore(score);
        score1.setCourse(course);
        score1.setSno(sno);
        int i = scoreService.update(score1);
        if (i == 0) {
            return "更新失败";
        } else {
            return "更新成功";
        }
    }
}
