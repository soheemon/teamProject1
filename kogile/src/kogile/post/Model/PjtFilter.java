package kogile.post.Model;

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


@WebFilter("*.post")
public class PjtFilter implements Filter {


    public PjtFilter() {
    }


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest)request;
		HttpServletResponse response2 = (HttpServletResponse)response;
		HttpSession session = request2.getSession();
		
//		if(request.getParameter("pjt_no") != null) {
//			session.removeAttribute("pjt_no");
//			int pjt_no = Integer.parseInt(request.getParameter("pjt_no"));
//			session.setAttribute("pjt_no", pjt_no);
//			System.out.println(pjt_no);
//		}
		
		if(request.getParameter("p_no") != null) {
			session.removeAttribute("p_no");
			int p_no = Integer.parseInt(request.getParameter("p_no"));
			session.setAttribute("p_no", p_no);
			System.out.println(p_no);
		}
		
		
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
