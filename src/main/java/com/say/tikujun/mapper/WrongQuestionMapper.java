package com.say.tikujun.mapper;

import com.say.tikujun.pojo.Question;
import com.say.tikujun.pojo.SingleQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WrongQuestionMapper {
    void delWrongQuestion(@Param("id_s")Integer id_s, @Param("id_q")Integer id_q);
    List<Integer> selectWrongQuestion_s(@Param("id_s") Integer id_s);
    Question selectWrongQuestion_q(@Param("id_q") Integer id_q, @Param("type") String type);
    String selectWrongQuestion_t(@Param("id_q")Integer id_q);
    List<Integer> selectCollectionBar_s(@Param("id_s") Integer id_s);
    Question selectCollectionBar_q(@Param("id_q") Integer id_q, @Param("type") String type);
    String selectCollectionBar_t(@Param("id_q")Integer id_q);
}
