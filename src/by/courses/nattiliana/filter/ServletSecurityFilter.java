package by.courses.nattiliana.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*@WebFilter(*//*urlPatterns = {"/controller"},*//* servletNames = {"Controller"})
public class ServletSecurityFilter implements Filter {
    private FilterConfig filterConfig;

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        ClientType type = (ClientType) session.getAttribute(Parameters.USERROLE);
        if (type == null) {
            type = ClientType.GUEST;
            session.setAttribute(Parameters.USERROLE, type);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(ConfigConstants.LOGIN_PAGE_PATH);
            dispatcher.forward(req, resp);
            return;
        }
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        this.filterConfig = fConfig;
    }
}*/

/*@WebFilter( urlPatterns = {"/jsp*//*"},
initParams = { @WebInitParam(name = "LOGIN_PAGE", value = "/login.jsp")})
public class ServletSecurityFilter implements Filter {
    private String loginPath;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        loginPath = filterConfig.getInitParameter("LOGIN_PAGE");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + loginPath);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }*/
@WebFilter( urlPatterns = { "/jsp/*" },
        initParams = { @WebInitParam(name = "LOGIN_PATH", value = "/login.jsp") })
public class ServletSecurityFilter implements Filter {
    private String loginPath;
    public void init(FilterConfig fConfig) throws ServletException {
        loginPath = fConfig.getInitParameter("LOGIN_PATH");
    }
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // переход на заданную страницу
        httpResponse.sendRedirect(httpRequest.getContextPath() + loginPath);
        chain.doFilter(request, response);
    }
    public void destroy() {
    }
}

