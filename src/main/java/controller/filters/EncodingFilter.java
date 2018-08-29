package controller.filters;

import javax.servlet.*;
import java.io.IOException;


public class EncodingFilter implements Filter {
    public final String ENCODING = "UTF-8";
    public final String CONTENTTYPE = "text/html";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        servletResponse.setContentType(CONTENTTYPE);
        servletResponse.setCharacterEncoding(ENCODING);
        servletRequest.setCharacterEncoding(ENCODING);
        chain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
