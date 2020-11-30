package com.ziqi.forum.mapper;

import com.ziqi.forum.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    int insert(User user);

    User select(User user);

    @Select({
            "select * from user where token = #{token} "
    })
    User findByToken(String token);

    User selectById(int id);

    User selectByAccountId(String account_id);


}
