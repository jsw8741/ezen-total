package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.CrabDAO;
import DTO.*;

@WebServlet("/")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2, location = "c:/Users/EZEN-33/eclipse-workspace/ezenCrab/img")
public class CrabController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CrabDAO dao; // model
	private ServletContext ctx;

	public CrabController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new CrabDAO();
		ctx = getServletContext();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getServletPath();
		String site = null;

		System.out.println(command);

		switch (command) {
		case "/selectUser":
			site = getSelect_user(request);
			break;

		case "/login":
			site = getLogin_status(request);
			break;

		case "/check":
			site = getCheck(request);
			break;

		case "/mypage":
			site = getMypage(request);
			break;

		case "/updatePage":
			site = getUpdatePage(request);
			break;
			
		case "/update":
			site = UpdateInfo(request);
			break;
		
		case "/join":
			site = join(request);
			break;
			
		case "/insert":
			site = insert(request);
			break;
		
		case "/delete":
			site = delete(request);
			break;
		}

		if (site.startsWith("redirect")) { // redirect
			// redirect 경로만 잘라온다.
			String rview = site.substring("redirect:/".length());
			response.sendRedirect(rview); // 페이지 이동

		} else { // forward
			ctx.getRequestDispatcher("/" + site).forward(request, response);
		}

	}

	public String getSelect_user(HttpServletRequest request) {

		try {
			Product p = dao.getSelect_user();
			request.setAttribute("product", p);

		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("상품 logo를 가져오는 과정에서 문제 발생");
			request.setAttribute("error", "상품 logo를 정상적으로 가져오지 못했습니다.");
		}

		return "index.jsp";
	}

	public String getLogin_status(HttpServletRequest request) {
		String status = request.getParameter("status");

		request.setAttribute("status", status);

		return "login.jsp";
	}

	public String getCheck(HttpServletRequest request) {
		if (request.getParameter("status").equals("관리자")) {
			try {
				Manager m = dao.getManager_login(request.getParameter("id"), request.getParameter("pw"));

				if (m.getManager_name() != null) {
					request.setAttribute("manager", m);
					return "manager.jsp";
				}

			} catch (Exception e) {
				e.printStackTrace();
				ctx.log("관리자 데이터를 가져오는 과정에서 문제 발생");
				request.setAttribute("error", "관리자 데이터를 정상적으로 가져오지 못했습니다.");
			}
		} else if (request.getParameter("status").equals("회원") ||
				request.getParameter("status").equals("gest")) {
			try {
				Member mem = dao.getMember_login(request.getParameter("id"), request.getParameter("pw"));
		
				if (mem.getMember_name() != null || request.getParameter("status").equals("gest") ||
					Integer.parseInt(request.getParameter("member_no")) > 0)
				{
					BeanUtils.populate(mem, request.getParameterMap());
					ArrayList<Product> p_list = dao.getP_List();
					
					request.setAttribute("status", request.getParameter("status"));
					request.setAttribute("member", mem);
					request.setAttribute("p_list", p_list);

					return "shop.jsp";
				}

			} catch (Exception e) {
				e.printStackTrace();
				ctx.log("회원 데이터를 가져오는 과정에서 문제 발생");
				request.setAttribute("error", "회원 데이터를 정상적으로 가져오지 못했습니다.");
			}
		}
		
		
		
		
		request.setAttribute("status", request.getParameter("status"));
		request.setAttribute("result", "fail");
		return "login.jsp";
	}

	public String getMypage(HttpServletRequest request) {
		try {
			Member mem = dao.getMypage(Integer.parseInt(request.getParameter("member_no")));

			request.setAttribute("member", mem);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "mypage.jsp";
	}
	
	public String getUpdatePage(HttpServletRequest request) {
		try {
			Member mem = dao.getMypage(Integer.parseInt(request.getParameter("member_no")));
			
			request.setAttribute("member", mem);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "update.jsp";
	}
	
	public String UpdateInfo(HttpServletRequest request) {
		Member mem = new Member();
		
		try {
			BeanUtils.populate(mem, request.getParameterMap());
			dao.UpdateInfo(mem);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("개인정보를 수정하는 과정에서 문제 발생");
			
			try {
				String encodeName = URLEncoder.encode("개인정보가 정상적으로 수정되지 않았습니다.", "UTF-8");
				return "redirect:/mypage?member_no=" + mem.getMember_no() + "&error=" + encodeName;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		
		
		return "redirect:/mypage?member_no=" + mem.getMember_no();
	}
	
	public String join(HttpServletRequest request) {
		request.setAttribute("status", request.getParameter("status"));
		
		return "join.jsp";
	}
	
	public String insert(HttpServletRequest request) {
		Member mem = new Member();
		
		try {
			BeanUtils.populate(mem, request.getParameterMap());
			dao.insertMember(mem);
			
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("회원 등록하는 과정에서 문제 발생");
			
			try {
				String encodeName = URLEncoder.encode("회원이 정상적으로 등록되지 않았습니다.", "UTF-8");
				return "redirect:/selectUser" + encodeName;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		
		return "redirect:/selectUser";
	}
	
	public String delete(HttpServletRequest request) {
		
		try {
			dao.deleteMember(Integer.parseInt(request.getParameter("member_no")));
			
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("회원 탈퇴 과정에서 문제 발생");
			
			try {
				String encodeName = URLEncoder.encode("회원이 정상적으로 탈퇴되지 않았습니다.", "UTF-8");
				return "redirect:/selectUser" + encodeName;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		
		return "redirect:/selectUser";
	}
}
