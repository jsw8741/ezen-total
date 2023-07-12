package ch08.quiz;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registController")
public class RegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RegistService service; // model
	
	
	// 프로그램 실행 후 최초로 request 돌아왔을 때 딱 한 번만 실행된다.
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		service = new RegistService();
	}

    public RegistController() {
        super();
    }


	@Override
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String view = "";
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/registController?action=list").forward(request, response);
		}else {
			switch(action) {
			case "list": view = list(request, response); break;
			case "info": view = info(request, response); break;
			}
			
			getServletContext().getRequestDispatcher("/ch08/quiz/" + view).forward(request, response);
		}
	}


	// 전체 고객 정보
	private String list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Regist> regists = service.findAll();
		
		request.setAttribute("regists", regists);
		return "registList.jsp";
	}
	
	// 고객 상세 정보
	private String info(HttpServletRequest request, HttpServletResponse response) {
		Regist regist = service.find(request.getParameter("id"));
		
		request.setAttribute("regist", regist);
		return "registInfo.jsp";
	}
	
	

}
