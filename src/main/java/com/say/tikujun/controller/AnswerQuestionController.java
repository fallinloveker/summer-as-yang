package com.say.tikujun.controller;

import com.mysql.cj.xdevapi.JsonArray;
import com.say.tikujun.mapper.AnswerQuestionMapper;
import com.say.tikujun.pojo.*;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AnswerQuestionController {
    @Autowired
    AnswerQuestionMapper answerQuestionMapper;
    @PostMapping("/AnswerQuestion")
    public Map<Integer, Object> AnswerQuestion(@RequestBody AnswerQuestion answerQuestion)
    {
        String subject = "'" + answerQuestion.getSubject() + "'";
        String subtype = "'" + answerQuestion.getSubtype() + "'";
        Map<Integer, Object> map = new HashMap<Integer, Object>(3);
        int i = 0;
        for(;i<answerQuestionMapper.getQuestion(subject, subtype).size();i++)
        {
            int state = 0;
            state = answerQuestionMapper.getCollectionBar(answerQuestion.getId(), answerQuestionMapper.getQuestion(subject, subtype).get(i).getId());
            Map<String, Object> map_t = new HashMap<String, Object>(3);
            map_t.put("id", answerQuestionMapper.getQuestion(subject, subtype).get(i).getId());
            map_t.put("question", answerQuestionMapper.getQuestion(subject, subtype).get(i).getQuestion());
            map_t.put("answer_a", answerQuestionMapper.getQuestion(subject, subtype).get(i).getAnswer_a());
            map_t.put("answer_b", answerQuestionMapper.getQuestion(subject, subtype).get(i).getAnswer_b());
            map_t.put("answer_c", answerQuestionMapper.getQuestion(subject, subtype).get(i).getAnswer_c());
            map_t.put("answer_d", answerQuestionMapper.getQuestion(subject, subtype).get(i).getAnswer_d());
            map_t.put("answer_true", answerQuestionMapper.getQuestion(subject, subtype).get(i).getAnswer_true());
            map_t.put("starMsg", state);
            map.put(i,map_t);
        }
        return map;
    }
    @PostMapping("/CollectionBarOperate")
    public void CollectionBarOperate(@RequestBody CollectionBar collectionBar)
    {
        if(collectionBar.getOperation().equals("add"))
        {
            answerQuestionMapper.addCollectionBar(collectionBar.getId_s(),collectionBar.getId_q());
        } else if (collectionBar.getOperation().equals("delete")) {
            answerQuestionMapper.delCollectionBar(collectionBar.getId_s(),collectionBar.getId_q());
        }
    }
    @PostMapping("/AnswerSubmit")
    public void AnswerSubmit(@RequestBody Map<String,Map<String,Map<String,Integer>>> map) {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int i = 0;
        for (; i < map.get("values").size(); i++) {
            if(map.get("values").get(String.valueOf(i)).get("result") != 999)
            {
                if(answerQuestionMapper.checkQuestionDate(year, month) == 0)
                {
                    answerQuestionMapper.insertQuestionDate(year, month);
                }
                else{
                    System.out.println(answerQuestionMapper.getQuestionDateType(map.get("values").get(String.valueOf(i)).get("id_q")));
                    if(answerQuestionMapper.getQuestionDateType(map.get("values").get(String.valueOf(i)).get("id_q")).equals("DataStruct"))
                    {
                        answerQuestionMapper.updateQuestionDateDataStruct_all(year, month);
                    }
                    else if(answerQuestionMapper.getQuestionDateType(map.get("values").get(String.valueOf(i)).get("id_q")).equals("OperationSys"))
                    {
                        answerQuestionMapper.updateQuestionDateOperationSys_all(year, month);
                    }
                    else if(answerQuestionMapper.getQuestionDateType(map.get("values").get(String.valueOf(i)).get("id_q")).equals("ComputerOrg"))
                    {
                        answerQuestionMapper.updateQuestionDateComputerOrg_all(year, month);
                    }
                    else if(answerQuestionMapper.getQuestionDateType(map.get("values").get(String.valueOf(i)).get("id_q")).equals("ComputerNet"))
                    {
                        answerQuestionMapper.updateQuestionDateComputerNet_all(year, month);
                    }
                }
                answerQuestionMapper.updateQuestionOptInfo_all(map.get("values").get(String.valueOf(i)).get("id_q"));
                answerQuestionMapper.addStudentQuestion(map.get("values").get(String.valueOf(i)).get("id_s"));
                if(map.get("values").get(String.valueOf(i)).get("answers") == 1)
                {
                    answerQuestionMapper.updateQuestionOptInfo_a(map.get("values").get(String.valueOf(i)).get("id_q"));
                } else if (map.get("values").get(String.valueOf(i)).get("answers") == 2) {
                    answerQuestionMapper.updateQuestionOptInfo_b(map.get("values").get(String.valueOf(i)).get("id_q"));
                }else if (map.get("values").get(String.valueOf(i)).get("answers") == 3) {
                    answerQuestionMapper.updateQuestionOptInfo_c(map.get("values").get(String.valueOf(i)).get("id_q"));
                }else if (map.get("values").get(String.valueOf(i)).get("answers") == 4) {
                    answerQuestionMapper.updateQuestionOptInfo_d(map.get("values").get(String.valueOf(i)).get("id_q"));
                }
                if(map.get("values").get(String.valueOf(i)).get("result") == 0)
                {
                    if (answerQuestionMapper.checkQuestionWrong(map.get("values").get(String.valueOf(i)).get("id_s"), map.get("values").get(String.valueOf(i)).get("id_q")) == 0) {
                        answerQuestionMapper.addQuestionWrong(map.get("values").get(String.valueOf(i)).get("id_s"), map.get("values").get(String.valueOf(i)).get("id_q"));
                    }
                } else if (map.get("values").get(String.valueOf(i)).get("result") == 1) {
                    answerQuestionMapper.addStudentTrue(map.get("values").get(String.valueOf(i)).get("id_s"));
                    answerQuestionMapper.updateQuestionOptInfo_true(map.get("values").get(String.valueOf(i)).get("id_q"));
                    if(answerQuestionMapper.getQuestionDateType(map.get("values").get(String.valueOf(i)).get("id_q")).equals("DataStruct"))
                    {
                        answerQuestionMapper.updateQuestionDateDataStruct_true(year, month);
                    }
                    else if(answerQuestionMapper.getQuestionDateType(map.get("values").get(String.valueOf(i)).get("id_q")).equals("OperationSys"))
                    {
                        answerQuestionMapper.updateQuestionDateOperationSys_true(year, month);
                    }
                    else if(answerQuestionMapper.getQuestionDateType(map.get("values").get(String.valueOf(i)).get("id_q")).equals("ComputerOrg"))
                    {
                        answerQuestionMapper.updateQuestionDateComputerOrg_true(year, month);
                    }
                    else if(answerQuestionMapper.getQuestionDateType(map.get("values").get(String.valueOf(i)).get("id_q")).equals("ComputerNet"))
                    {
                        answerQuestionMapper.updateQuestionDateComputerNet_true(year, month);
                    }
                }
            }
        }
    }
    @PostMapping("/SingleQuestion")
    public Map<String, Object>  SingleQuestion(@RequestBody SingleQuestion singleQuestion)
    {
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put("id", answerQuestionMapper.getSingleQuestion(singleQuestion.getId_q()).get(0).getId());
        map.put("type", answerQuestionMapper.getSingleQuestion(singleQuestion.getId_q()).get(0).getType());
        map.put("question", answerQuestionMapper.getSingleQuestion(singleQuestion.getId_q()).get(0).getQuestion());
        map.put("answer_a", answerQuestionMapper.getSingleQuestion(singleQuestion.getId_q()).get(0).getAnswer_a());
        map.put("answer_b", answerQuestionMapper.getSingleQuestion(singleQuestion.getId_q()).get(0).getAnswer_b());
        map.put("answer_c", answerQuestionMapper.getSingleQuestion(singleQuestion.getId_q()).get(0).getAnswer_c());
        map.put("answer_d", answerQuestionMapper.getSingleQuestion(singleQuestion.getId_q()).get(0).getAnswer_d());
        map.put("answer_true", answerQuestionMapper.getSingleQuestion(singleQuestion.getId_q()).get(0).getAnswer_true());
        map.put("starMsg", answerQuestionMapper.getCollectionBar(singleQuestion.getId_s(), singleQuestion.getId_q()));
        System.out.println(answerQuestionMapper.getCollectionBar(singleQuestion.getId_s(), singleQuestion.getId_q()));
        System.out.println(singleQuestion.getId_q());
        System.out.println(singleQuestion.getId_s());
        return map;

    }
    @PostMapping("selectSubtype")
    public Map<String, Object> selectSubtype()
    {
        String[] type = {"'DataStruct'", "'OperationSys'", "'ComputerOrg'", "'ComputerNet'"};
        Map<String, Object> map = new HashMap<String, Object>(3);
        for(int j = 0;j<4;j++) {
            Map<Integer, Object> map_t = new HashMap<Integer, Object>(3);
            for (int i = 0; i < answerQuestionMapper.selectSubtype(type[j]).size(); i++) {
                map_t.put(i, answerQuestionMapper.selectSubtype(type[j]).get(i));
            }
            map.put(type[j], map_t);
        }
        return map;
    }
    @PostMapping("/getStudentQuestionInfo")
    public Map<String, Object> getStudentQuestionInfo(@RequestBody StudentQuestionInfo studentQuestionInfo)
    {
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put("True", answerQuestionMapper.getStudentTrue(studentQuestionInfo.getId_s()));
        map.put("Question", answerQuestionMapper.getStudentQuestion(studentQuestionInfo.getId_s()));
        map.put("Name", answerQuestionMapper.getStudentName(studentQuestionInfo.getId_s()));
        return map;
    }
}
