package by.courses.nattiliana.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Nataly on 25.11.2016.
 * ${VERSION}
 */
public class EncodingFilter implements Filter {

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {	}
}
