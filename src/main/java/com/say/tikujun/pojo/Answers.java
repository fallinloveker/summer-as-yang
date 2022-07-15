package com.say.tikujun.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answers {
    Integer[] id_q;
    Integer id_s;
    String[] result;
}
