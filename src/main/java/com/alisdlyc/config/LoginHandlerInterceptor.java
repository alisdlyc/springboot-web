package com.alisdlyc.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 拦截器 只有正确输入账号密码才能进入main.html
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 登陆成功后，应该能获取用户的session
        Object loginUser = request.getSession().getAttribute("LoginUser");

        if (loginUser==null){
            request.setAttribute("msg","权限获取失败，请重新登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}
