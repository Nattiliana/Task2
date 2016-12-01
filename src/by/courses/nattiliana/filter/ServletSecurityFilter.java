package by.courses.nattiliana.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/jsp/*"},
        initParams = {@WebInitParam(name = "LOGIN_PATH", value = "/login.jsp")})
public class ServletSecurityFilter implements Filter {
    private String loginPath;

    public void init(FilterConfig fConfig) throws ServletException {
        loginPath = fConfig.getInitParameter("LOGIN_PATH");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect(httpRequest.getContextPath() + loginPath);
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}

