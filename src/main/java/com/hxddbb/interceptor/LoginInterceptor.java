package com.hxddbb.interceptor;

import com.hxddbb.entity.lbuser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        lbuser user = (lbuser) session.getAttribute("user");
        if (user == null) {//如果没登陆就重定向到登录视图
            response.sendRedirect(request.getContextPath() + "/home/user/loginregistpage");
            return false;
        }
        return true;
    }
}
