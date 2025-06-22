package spring.boot.revamp.filters.multipleFilter;

import jakarta.servlet.*;

import java.io.IOException;

// doFilter() calls the next filter if one is there otherwise sends the request to the Dispatcher servlet

public class MyFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Inside Filter1");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("MyFilter1 completed");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
