package com.say.tikujun.controller;

import com.say.tikujun.mapper.WrongQuestionMapper;
import com.say.tikujun.pojo.SingleQuestion;
import com.say.tikujun.pojo.WrongQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WrongQuestionController {
    @Autowired
    WrongQuestionMapper wrongQuestionMapper;
    @PostMapping("/delWrongQuestion")
    public void delWrongQuestion(@RequestBody SingleQuestion singleQuestion){
        System.out.println(singleQuestion.getId_s());
        System.out.println(singleQuestion.getId_q());
        wrongQuestionMapper.delWrongQuestion(singleQuestion.getId_s(), singleQuestion.getId_q());
    }
    @PostMapping("/selectWrongQuestion")
    public Map<String, Object> selectWrongQuestion(@RequestBody WrongQuestion wrongQuestion){
        int a =0,b =0, c=0,d =0;
        Integer id_s = wrongQuestion.getId_s();
        Map<String, Object> map = new HashMap<String, Object>(3);
        String[] type1 = {"'DataStruct'", "'OperationSys'","'ComputerOrg'","'ComputerNet'"};
        Map<Integer, Object> map_1 = new HashMap<Integer, Object>(3);
        Map<Integer, Object> map_2 = new HashMap<Integer, Object>(3);
        Map<Integer, Object> map_3 = new HashMap<Integer, Object>(3);
        Map<Integer, Object> map_4 = new HashMap<Integer, Object>(3);
            for(int i = 0;i<wrongQuestionMapper.selectWrongQuestion_s(id_s).size();i++)
            {
                if(wrongQuestionMapper.selectWrongQuestion_t(wrongQuestionMapper.selectWrongQuestion_s(id_s).get(i)).equals("DataStruct"))
                {
                    Map<String, Object> map_t1 = new HashMap<String, Object>(3);
                    map_t1.put("id", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectWrongQuestion_s(id_s).get(i), type1[0]).getId());
                    map_t1.put("question", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectWrongQuestion_s(id_s).get(i), type1[0]).getQuestion());
                    map_1.put(a++,map_t1);
                } else if (wrongQuestionMapper.selectWrongQuestion_t(wrongQuestionMapper.selectWrongQuestion_s(id_s).get(i)).equals("OperationSys")) {
                    Map<String, Object> map_t2 = new HashMap<String, Object>(3);
                    map_t2.put("id", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectWrongQuestion_s(id_s).get(i), type1[1]).getId());
                    map_t2.put("question", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectWrongQuestion_s(id_s).get(i), type1[1]).getQuestion());
                    map_2.put(b++,map_t2);
                }else if (wrongQuestionMapper.selectWrongQuestion_t(wrongQuestionMapper.selectWrongQuestion_s(id_s).get(i)).equals("ComputerOrg")) {
                    Map<String, Object> map_t3 = new HashMap<String, Object>(3);
                    map_t3.put("id", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectWrongQuestion_s(id_s).get(i), type1[2]).getId());
                    map_t3.put("question", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectWrongQuestion_s(id_s).get(i), type1[2]).getQuestion());
                    map_3.put(c++,map_t3);
                }else if (wrongQuestionMapper.selectWrongQuestion_t(wrongQuestionMapper.selectWrongQuestion_s(id_s).get(i)).equals("ComputerNet")) {
                    Map<String, Object> map_t4 = new HashMap<String, Object>(3);
                    map_t4.put("id", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectWrongQuestion_s(id_s).get(i), type1[3]).getId());
                    map_t4.put("question", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectWrongQuestion_s(id_s).get(i), type1[3]).getQuestion());
                    map_4.put(d++,map_t4);
                }
            }
            map.put("DataStruct",map_1);
        map.put("OperationSys",map_2);
        map.put("ComputerOrg",map_3);
        map.put("ComputerNet",map_4);



        System.out.println(map);
        return map;
    }
    @PostMapping("/selectCollectionBar")
    public Map<String, Object> selectCollectionBar(@RequestBody WrongQuestion wrongQuestion){
        int a =0,b =0, c=0,d =0;
        Integer id_s = wrongQuestion.getId_s();
        Map<String, Object> map = new HashMap<String, Object>(3);
        String[] type1 = {"'DataStruct'", "'OperationSys'","'ComputerOrg'","'ComputerNet'"};
        Map<Integer, Object> map_1 = new HashMap<Integer, Object>(3);
        Map<Integer, Object> map_2 = new HashMap<Integer, Object>(3);
        Map<Integer, Object> map_3 = new HashMap<Integer, Object>(3);
        Map<Integer, Object> map_4 = new HashMap<Integer, Object>(3);
        for(int i = 0;i<wrongQuestionMapper.selectCollectionBar_s(id_s).size();i++)
        {
            if(wrongQuestionMapper.selectCollectionBar_t(wrongQuestionMapper.selectCollectionBar_s(id_s).get(i)).equals("DataStruct"))
            {
                Map<String, Object> map_t1 = new HashMap<String, Object>(3);
                map_t1.put("id", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectCollectionBar_s(id_s).get(i), type1[0]).getId());
                map_t1.put("question", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectCollectionBar_s(id_s).get(i), type1[0]).getQuestion());
                map_1.put(a++,map_t1);
            } else if (wrongQuestionMapper.selectWrongQuestion_t(wrongQuestionMapper.selectCollectionBar_s(id_s).get(i)).equals("OperationSys")) {
                Map<String, Object> map_t2 = new HashMap<String, Object>(3);
                map_t2.put("id", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectCollectionBar_s(id_s).get(i), type1[1]).getId());
                map_t2.put("question", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectCollectionBar_s(id_s).get(i), type1[1]).getQuestion());
                map_2.put(b++,map_t2);
            }else if (wrongQuestionMapper.selectWrongQuestion_t(wrongQuestionMapper.selectCollectionBar_s(id_s).get(i)).equals("ComputerOrg")) {
                Map<String, Object> map_t3 = new HashMap<String, Object>(3);
                map_t3.put("id", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectCollectionBar_s(id_s).get(i), type1[2]).getId());
                map_t3.put("question", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectCollectionBar_s(id_s).get(i), type1[2]).getQuestion());
                map_3.put(c++,map_t3);
            }else if (wrongQuestionMapper.selectWrongQuestion_t(wrongQuestionMapper.selectCollectionBar_s(id_s).get(i)).equals("ComputerNet")) {
                Map<String, Object> map_t4 = new HashMap<String, Object>(3);
                map_t4.put("id", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectCollectionBar_s(id_s).get(i), type1[3]).getId());
                map_t4.put("question", wrongQuestionMapper.selectWrongQuestion_q(wrongQuestionMapper.selectCollectionBar_s(id_s).get(i), type1[3]).getQuestion());
                map_4.put(d++,map_t4);
            }
        }
        map.put("DataStruct",map_1);
        map.put("OperationSys",map_2);
        map.put("ComputerOrg",map_3);
        map.put("ComputerNet",map_4);



        System.out.println(map);
        return map;
    }
}
