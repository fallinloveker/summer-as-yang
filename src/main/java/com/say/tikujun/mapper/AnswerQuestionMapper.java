package com.say.tikujun.mapper;

import com.say.tikujun.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnswerQuestionMapper {
    List<Question> getQuestion(@Param("subject") String subject, @Param("subtype") String subtype);
    Integer getCollectionBar(@Param("id_s") Integer id_s,@Param("id_q") Integer id_q);
    void delCollectionBar(@Param("id_s") Integer id_s, @Param("id_q") Integer id_q);
    void addCollectionBar(@Param("id_s") Integer id_s, @Param("id_q") Integer id_q);
    void addQuestionWrong(@Param("id_s") Integer id_s, @Param("id_q") Integer id_q);
    int checkQuestionWrong(@Param("id_s") Integer id_s, @Param("id_q") Integer id_q);
    List<Question> getSingleQuestion(@Param("id_q") Integer in_q);
    int checkSingleCollection(@Param("id_s") Integer id_s, @Param("id_q") Integer id_q);
    List<String> selectSubtype(@Param("type") String type);
    void addStudentTrue(@Param("id_s") Integer id_s);
    void addStudentQuestion(@Param("id_s") Integer id_s);
    Integer getStudentTrue(@Param("id_s") Integer id_s);
    Integer getStudentQuestion(@Param("id_s") Integer id_s);
    String getStudentName(@Param("id_s") Integer id_s);
    void updateQuestionOptInfo_a(@Param("id_q") Integer id_q);
    void updateQuestionOptInfo_b(@Param("id_q") Integer id_q);
    void updateQuestionOptInfo_c(@Param("id_q") Integer id_q);
    void updateQuestionOptInfo_d(@Param("id_q") Integer id_q);
    void updateQuestionOptInfo_true(@Param("id_q") Integer id_q);
    void updateQuestionOptInfo_all(@Param("id_q") Integer id_q);
    Integer checkQuestionDate(@Param("year") Integer year,
                              @Param("month") Integer month);
    void insertQuestionDate(@Param("year") Integer year,
                            @Param("month") Integer month);
    //数据结构
    void updateQuestionDateDataStruct_true(@Param("year") Integer year,
                                           @Param("month") Integer month);
    void updateQuestionDateDataStruct_all(@Param("year") Integer year,
                                           @Param("month") Integer month);
    //操作系统
    void updateQuestionDateOperationSys_true(@Param("year") Integer year,
                                           @Param("month") Integer month);
    void updateQuestionDateOperationSys_all(@Param("year") Integer year,
                                           @Param("month") Integer month);
    //计算机组成原理
    void updateQuestionDateComputerOrg_true(@Param("year") Integer year,
                                           @Param("month") Integer month);
    void updateQuestionDateComputerOrg_all(@Param("year") Integer year,
                                           @Param("month") Integer month);
    //计算机网络
    void updateQuestionDateComputerNet_true(@Param("year") Integer year,
                                           @Param("month") Integer month);
    void updateQuestionDateComputerNet_all(@Param("year") Integer year,
                                           @Param("month") Integer month);
    String getQuestionDateType(@Param("id_q") Integer id_q);
}
