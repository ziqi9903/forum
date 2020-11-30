package com.ziqi.forum.mapper;

import com.ziqi.forum.entity.Question;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {

    void insertQuestion(Question question);
}
