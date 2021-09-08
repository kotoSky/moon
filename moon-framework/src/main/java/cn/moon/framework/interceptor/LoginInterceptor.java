package cn.moon.framework.interceptor;

import cn.moon.system.domain.SysUser;
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

        String contextPath = session.getServletContext().getContextPath();

        String[] requireAuthPages = new String[]{
                "index",
        };

        String uri = request.getRequestURI();
        uri = uri.replace(contextPath + "/", "");
        String page = uri;

        if (begingWith(page, requireAuthPages)) {
            SysUser user = (SysUser) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("login");
                return false;
            }
        }
        return true;
    }

    private boolean begingWith(String page, String[] requiredAuthPages) {
        boolean result = false;
        for (String requiredAuthPage : requiredAuthPages) {
            if (page.startsWith(requiredAuthPage)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
