package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.PboardVo;
import board.service.BoardService;
import board.service.BoardServiceInf;

public class CommandPboardDelete implements CommandInf {

	@Override
	public void excute(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		//service 객체 만들기
		BoardServiceInf service = BoardService.getInstance();
		
		String pboard_seq =request.getParameter("pboard_seq");
		service.deletePboard(pboard_seq);
		
		//pboard update
		List<PboardVo> pboardList = service.pboardList((String)session.getAttribute("mem_id"));
		session.setAttribute("pboardList", pboardList);
		
	}

}
