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

public class CommandPboardController implements CommandInf {

	@Override
	public void excute(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		//서비스 객체얻기
		BoardServiceInf service = BoardService.getInstance();
		
		
		String pboard_reg_id = (String) session.getAttribute("mem_id");
		System.out.println(pboard_reg_id +"  CommandPboardController id");
		String allMember= "brown";
		List<PboardVo> pboardList = service.pboardList(allMember);
		
		//세션에 담기
		session.setAttribute("pboardList", pboardList);
	}

}
