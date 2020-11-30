package com.ziqi.forum.controller;

import com.ziqi.forum.dto.AccessTokenDto;
import com.ziqi.forum.dto.GithubUser;
import com.ziqi.forum.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    /**
     * param 用于接收按钮提交的事件
     * code 和 state 用来记录 /callback get 请求时的提交的值
     * @param code 获取网页提交时的code
     * @param state 获取网页提交时的state
     * @return
     * 页面 uri = http://localhost:8081/callback
     */
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String clientUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state
                            ){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(clientSecret);
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri(clientUri);
        accessTokenDto.setState(state);
        /**
         * 获取github返回的Token 并记录下来
         * 转为需要的String字符串然后切分的到自己需要的参数
         */
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        /**
         * 传回github accessToken
         * 请求返回 user 的信息
         */
        GithubUser user = githubProvider.getUser(accessToken);

        /**
         * 返回重定向的网页
         * 登录完成后仍然返回到主页
         */
        return "index";
    }


}
