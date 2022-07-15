package com.say.tikujun.controller;

import com.say.tikujun.mapper.AdministratorAnalysisMapper;
import com.say.tikujun.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
public class AdministratorAnalysisController {
    @Autowired
    AdministratorAnalysisMapper administratorAnalysisMapper;
    @PostMapping("/A_getQuestionInfo")
    public Map<String, Object> A_getQuestionInfo()
    {
        Map<String, Object> map = new HashMap<String, Object>(3);
        administratorAnalysisMapper.A_getQuestionInfo_type();
        for(int i = 0;i<administratorAnalysisMapper.A_getQuestionInfo_type().size();i++)
        {
            Map<String, Object> map_t = new HashMap<String, Object>(3);
            for(int j = 0;j<administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").size();j++)
            {
                Map<Integer, Object> map_s= new HashMap<Integer, Object>(3);
                for(int k = 0;k<administratorAnalysisMapper.A_getQuestionInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").size();k++)
                {
                    Map<String, Object> map_q= new HashMap<String, Object>(3);
                    map_q.put("id", administratorAnalysisMapper.A_getQuestionInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").get(k).getId());
                    map_q.put("question", administratorAnalysisMapper.A_getQuestionInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").get(k).getQuestion());
                    map_q.put("answer_a", administratorAnalysisMapper.A_getQuestionInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").get(k).getAnswer_a());
                    map_q.put("answer_b", administratorAnalysisMapper.A_getQuestionInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").get(k).getAnswer_b());
                    map_q.put("answer_c", administratorAnalysisMapper.A_getQuestionInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").get(k).getAnswer_c());
                    map_q.put("answer_d", administratorAnalysisMapper.A_getQuestionInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").get(k).getAnswer_d());
                    map_q.put("answer_true", administratorAnalysisMapper.A_getQuestionInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").get(k).getAnswer_true());
                    map_s.put(k, map_q);
                }
                map_t.put(administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j), map_s);
            }
            map.put(administratorAnalysisMapper.A_getQuestionInfo_type().get(i), map_t);
        }
        System.out.println(map);
        return map;
    }

    @GetMapping("/A_getQuestionNumberInfo")
    public Map<String, Object> A_getQuestionNumberInfo()
    {
        Map<String, Object> map = new HashMap<String, Object>(3);
        administratorAnalysisMapper.A_getQuestionInfo_type();
        for(int i = 0;i<administratorAnalysisMapper.A_getQuestionInfo_type().size();i++)
        {
            Map<String, Object> map_t = new HashMap<String, Object>(3);
            for(int j = 0;j<administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").size();j++)
            {
                Map<Integer, Object> map_s= new HashMap<Integer, Object>(3);
                for(int k = 0;k<administratorAnalysisMapper.A_getQuestionInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").size();k++)
                {
                    Map<String, Integer> map_q= new HashMap<String, Integer>(3);
                    map_q.put("id", administratorAnalysisMapper.A_getQuestionNumberInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").get(k).getId_q());
                    map_q.put("number_a", administratorAnalysisMapper.A_getQuestionNumberInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").get(k).getNumber_a());
                    map_q.put("number_b", administratorAnalysisMapper.A_getQuestionNumberInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").get(k).getNumber_b());
                    map_q.put("number_c", administratorAnalysisMapper.A_getQuestionNumberInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").get(k).getNumber_c());
                    map_q.put("number_d", administratorAnalysisMapper.A_getQuestionNumberInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").get(k).getNumber_d());
                    map_q.put("number_true", administratorAnalysisMapper.A_getQuestionNumberInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").get(k).getNumber_true());
                    map_q.put("number_all", administratorAnalysisMapper.A_getQuestionNumberInfo("'" + administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j) + "'").get(k).getNumber_true());
                    map_s.put(k, map_q);
                }
                map_t.put(administratorAnalysisMapper.A_getQuestionInfo_subtype("'" + administratorAnalysisMapper.A_getQuestionInfo_type().get(i) + "'").get(j), map_s);
            }
            map.put(administratorAnalysisMapper.A_getQuestionInfo_type().get(i), map_t);
        }
        System.out.println(map);
        return map;
    }
    @GetMapping("/test123")
    public String test(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        return "asd";
    }
   /* @PostMapping("/getQuestionType")
    public String getQuestionType(@RequestParam String type)
    {
        Map<Integer,String> map = new HashMap<Integer, String>(3);
        administratorAnalysisMapper.getQuestionType("type");
        for(int i = 0;i<administratorAnalysisMapper.getQuestionType("type").size();i++)
        {
            map.put(i,administratorAnalysisMapper.getQuestionType("type").get(i));
        }
        return "sdsada";
    }*/
    @PostMapping("/getQuestionInfo")
    public Map<Integer,Object> getQuestionInfo(@RequestParam String type)
    {
        System.out.println(type);
        type = "'" + type + "'";
        String[][] array = null;
        Map<Integer,Object> map = new HashMap<Integer, Object>(3);
        for(int i = 0;i<administratorAnalysisMapper.getQuestionType(type).size();i++)
        {

            /*Map<String, Object> map_q = new HashMap<String, Object>(3);
            map_q.put("id", administratorAnalysisMapper.getQuestionType(type).get(i).getId());
            map_q.put("question", administratorAnalysisMapper.getQuestionType(type).get(i).getQuestion());
            map_q.put("answer_a", administratorAnalysisMapper.getQuestionType(type).get(i).getAnswer_a());
            map_q.put("answer_b", administratorAnalysisMapper.getQuestionType(type).get(i).getAnswer_b());
            map_q.put("answer_c", administratorAnalysisMapper.getQuestionType(type).get(i).getAnswer_c());
            map_q.put("answer_d", administratorAnalysisMapper.getQuestionType(type).get(i).getAnswer_d());
            map_q.put("answer_true", administratorAnalysisMapper.getQuestionType(type).get(i).getAnswer_true());
            map.put(i, map_q);*/
        }
        System.out.println(map);
        return map;
    }
}
