package command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.PboardVo;
import board.service.BoardService;
import board.service.BoardServiceInf;

public class CommandLogin implements CommandInf{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		BoardServiceInf service = BoardService.getInstance();
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		Map<String, String> loginInfo = new HashMap<String, String>();
		loginInfo.put("mem_id", mem_id);
		loginInfo.put("mem_pass", mem_pass);
		int res = service.memberLogin(loginInfo);
		if(res==1){
			//로그인 성공
			List<PboardVo> pboardList = service.pboardList(mem_id);
			session.setAttribute("pboardList", pboardList);
			session.setAttribute("mem_id", mem_id);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.do");
			rd.forward(request, response);
		}
		
	}

}
