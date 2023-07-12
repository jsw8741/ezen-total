package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class helloword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public helloword() {
        super();	// HttpServlet의 생성자가 실행이 된다.
    }

    // request를 받을때 get 방식으로 주는 데이터를 받는다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req : request 정보(클라이언트로부터 받아온 정보가 있다.
		System.out.println(req.getRequestURI());
		
		// resp : response 정보(서버가 클라이언트에게 응답해주기 위해서 필요. -> 응답 데이터가 존재)
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.append("<!doctype html>"
					+ "<html>"
					+ "<head>"
					+ "<title>hello</title>"
					+ "</head>"
					+ "<body>"
		+"<h2>hello!</h2><hr>"
		+"현재 날짜와 시간은 : " + "<br>" + java.time.LocalDateTime.now()
		+"</body></html>");
					
		
//		resp.getWriter().append("Serves at : ").append(req.getContextPath());
	}

	// request를 받을때 post 방식으로 주는 데이터를 받는다.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req : request 정보(클라이언트로부터 받아온 정보가 있다.
		System.out.println(req.getRequestURI());
		doGet(req, resp);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		super.service(req, res);
	}

	
	
}
