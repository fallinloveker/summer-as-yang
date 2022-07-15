package com.say.tikujun.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    Integer id;
    String type;
    String question;
    String answer_a;
    String answer_b;
    String answer_c;
    String answer_d;
    char answer_true;
}
