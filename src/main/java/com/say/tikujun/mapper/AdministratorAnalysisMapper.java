package com.say.tikujun.mapper;

import com.say.tikujun.pojo.Question;
import com.say.tikujun.pojo.QuestionNumberInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdministratorAnalysisMapper {
    List<Question> A_getQuestionInfo(@Param("subtype") String subtype);
    List<String> A_getQuestionInfo_type();
    List<String> A_getQuestionInfo_subtype(@Param("type") String type);
    List<QuestionNumberInfo> A_getQuestionNumberInfo(@Param("subtype") String subtype);
    List<Question> getQuestionType(@Param("type") String type);
}
