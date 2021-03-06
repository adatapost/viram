package in.credit.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "EmployeeFilter", urlPatterns = {"/employee/*"})
public class EmployeeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession sess = req.getSession();
        Boolean isEmp = (Boolean) sess.getAttribute("isEmp");

        if (isEmp == null) {
            req.getRequestDispatcher("/home").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {
    }
}
