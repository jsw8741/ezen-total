package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String ss = "테스\n트";
		System.out.println(ss);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.append("<!doctype html>"
				+ "<html>"
				+ "<head>"
				+ "<title>로그인 "+ "" + " 결과</title>"
				+ "</head>"
				+ "<body>").append("<h1>로그인 결과</h1><hr>");
				
		if(id.equals("person") && pw.equals("1234")) {
			
			out.append(id + "님 반갑습니다.");
		}else {
			out.append("로그인 실패.");
		}
		
		
		out.append("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
