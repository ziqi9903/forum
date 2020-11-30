package com.ziqi.forum;

import com.ziqi.forum.entity.User;
import com.ziqi.forum.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ForumApplication.class)
class ForumApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = new User();
        user.setId(23);
        user.setToken(UUID.randomUUID().toString());
        user.setName("456");
        user.setAccount_id("z12");
        user.setGmt_create(System.currentTimeMillis());
        user.setGmt_modified(user.getGmt_create());

        userMapper.insert(user);
    }

}
