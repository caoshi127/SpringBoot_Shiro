package com.zzuli.filter;

import com.alibaba.fastjson.JSON;
import com.zzuli.utils.ResultObj;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ShiroLoginFilter extends FormAuthenticationFilter {

    /**
     * 当用户未登录时访问资源就执行该方法
     *
     * @param request
     * @param response
     * @return true 已登录,不用处理   false 未登录, 提示前端处理
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //判断用户是否是浏览器访问
        if (isAjax(request)) {
            ResultObj resultObj = ResultObj.UNLOGIN;
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.write(JSON.toJSONString(resultObj));
            out.flush();
            out.close();
        } else {    // 重定向
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendRedirect("/index.html");
        }

        return false;
    }

    /**
     * 判断当前请求是否为Ajax请求
     *
     * @param request
     * @return
     */
    private boolean isAjax(ServletRequest request) {
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if ("XMLHttpRequest".equalsIgnoreCase(header)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


}
