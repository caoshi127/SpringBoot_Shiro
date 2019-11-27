package com.zzuli.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zzuli.utils.ActiveUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Enumeration;

/**
 * @author CaoShi
 * @time 2019/11/20 22:38
 */
@Controller
@RequestMapping("login")
public class LoginController {

    /**
     * 跳转到登陆页面
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 做登陆
     */
    @RequestMapping("login")
    public String login(String username, String pwd, HttpSession session) {

        System.out.println("LoginController.login");

        //得到主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
        try {
            subject.login(token);
            System.out.println("登陆成功");
            ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
            session.setAttribute("user", activeUser.getUser());
            return "redirect:/user/toUserManager";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "redirect:/index.html";
        }
    }

    /**
     * 退出登录, 跳转到首页
     * @return
     */
    @RequestMapping("logOut")
    public String logOut(HttpServletRequest request) {
        System.out.println("LoginController.logOut");
        // 清空session
        Enumeration<String> an = request.getSession().getAttributeNames();
        while (an.hasMoreElements()) {
            request.getSession().removeAttribute(an.nextElement());
        }
        return "redirect:/index.html";
    }
}
