package com.codel.api.main;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.codel.api.utils.RobotApi;

import java.util.Scanner;

/**
 * 主要
 *
 * @author codel
 * @date 2021/09/17
 */
public class Main {
    private static final String apiKey = "a1f2059f905747198322c65f711a5b4c";
    private static final String userId = "codel";

    /**
     * 主要
     *
     * @param args arg游戏
     */
    public static void main(String[] args) {
        RobotApi api = new RobotApi(apiKey, userId);
        while (true) {
            System.out.println("==== 问题：=====");
            Scanner input = new Scanner(System.in);

            String word = input.next();
            String backString = api.getRobotResult(word);

            JSONObject jsonobj = JSON.parseObject(backString);
            JSONArray result = jsonobj.getJSONArray("results");
            for (int i = 0; i < result.size(); i++) {
                System.out.println("---回答---");
                System.out.println(result.getJSONObject(0).getJSONObject("values").getString("text"));
            }
        }
    }

}
