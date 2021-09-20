package com.codel.api.utils;

import com.codel.api.controller.HttpPost;

/**
 * 机器人api
 *
 * @author codel
 * @date 2021/09/17
 */
public class RobotApi {
    private static final String ROBOT_API_HOST = "http://openapi.tuling123.com/openapi/api/v2";
    private String key;
    private String userid;

    /**
     * 机器人api
     *
     * @param key    关键
     * @param userid 用户标识
     */
    public RobotApi(String key, String userid) {
        super();
        this.key = key;
        this.userid = userid;
    }

    /**
     * 建立参数   就是把数据弄成json的格式，因为要接收到的数据就是
     *
     * @param Word 词
     * @return {@link String}
     */
    private String buildParams(String Word) {
        String a = "{\"reqType\":0,\"perception\": {\"inputText\": {\"text\": \"";
        String b = "\"}},\"userInfo\": {\"apiKey\": \"";
        String c = "\",\"userId\": \"";
        String d = "\"}\r\n" + "}";
        String string = a + Word + b + key + c + userid + d;
        return string;

    }

    /**
     * 返回机器人的结果
     *
     * @param Word 词
     * @return {@link String}
     */
    public String getRobotResult(String Word) {

        return HttpPost.doPost(ROBOT_API_HOST, buildParams(Word));
    }
}

