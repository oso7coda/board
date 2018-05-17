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

public class CommandPboardCreate implements CommandInf{

	@Override
	public void excute(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		BoardServiceInf service = BoardService.getInstance();
		String pboard_name = request.getParameter("pboard_name");
		
		//부모게시판객체 생성
		PboardVo pboardVo = new PboardVo();
		pboardVo.setPboard_reg_id((String)session.getAttribute("mem_id"));
		pboardVo.setPboard_name(pboard_name);
		pboardVo.setPboard_del("yes");
		//service접속
		int res = service.createPboard(pboardVo);
		
		
		String pboard_reg_id = (String) session.getAttribute("mem_id");
		List<PboardVo> pboardList = service.pboardList(pboard_reg_id);
		
		//세션에 담기
		session.setAttribute("pboardList", pboardList);
		
	}

}
