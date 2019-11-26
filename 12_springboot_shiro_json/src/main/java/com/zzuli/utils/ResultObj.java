package com.zzuli.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * 返回结果常量类
 *
 * @author CaoShi
 * @time 2019/11/23 14:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultObj {

    public static final ResultObj UNLOGIN = new ResultObj("403", "未登录");
    public static final ResultObj UNAUTHORIZED = new ResultObj("405", "未授权");
    public static final ResultObj LOGIN_SUCCESS = new ResultObj("200", "登录成功");
    public static final ResultObj LOGIN_ERROR = new ResultObj("-1", "登录失败");

    private String code;        // 状态码
    private String msg;         // 状态信息
}
