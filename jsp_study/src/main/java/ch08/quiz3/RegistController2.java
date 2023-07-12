package ch08.quiz3;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;



@WebServlet("/registController3")
public class RegistController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RegistDAO2 dao; // model
	
	public RegistController2() {
		super();
	}
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new RegistDAO2();
	}



	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String view = "";
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/registController3?action=list").forward(request, response);
		}else {
			switch(action) {
			case "list": view = list(request, response); break;
			case "info": view = info(request, response); break;
			case "insert" : view = insert(request, response); break;
			}
			
			getServletContext().getRequestDispatcher("/ch08/quiz2/" + view).forward(request, response);
		}
	}


	// 전체 고객 정보
	private String list(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("regists", dao.getAll());
		
		return "registList2.jsp";
	}
	
	// 고객 상세 정보
	private String info(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("regist", dao.find(request.getParameter("id")));
		
		return "registInfo2.jsp";
	}
	
	// 회원 등록
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		Regist2 r = new Regist2();
		
		try {
			BeanUtils.populate(r, request.getParameterMap());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		dao.insert(r);
		
		return "registList2.jsp";
	}
}