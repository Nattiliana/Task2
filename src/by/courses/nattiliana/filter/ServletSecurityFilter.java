package by.courses.nattiliana.filter;

import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.constants.Parameters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(/*urlPatterns = {"/controller"},*/ servletNames = {"Controller"})
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
}
