package com.xl.download;

import com.xl.download.bean.User;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class MyLoginInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String user = (String) request.getSession().getAttribute("loginUser");
            LoggerFactory.getLogger(getClass()).info(request.getContextPath() + "你的登陆页地址" + user + "" +request.getRequestURI());

            if (user != null||request.getRequestURI().equals("/download")) {

                return true;
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
                return false;
            }
        } catch (Exception exception) {

            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
