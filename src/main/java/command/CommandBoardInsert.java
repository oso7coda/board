package command;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardVo;
import board.service.BoardService;
import board.service.BoardServiceInf;

public class CommandBoardInsert implements CommandInf{

	@Override
	public void excute(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
				//request form attr
				String board_title = request.getParameter("board_title");
				String board_content ="";
				if(request.getParameter("board_content")!=null){
					board_content= request.getParameter("board_content");
				}
				String pboard_seq = session.getAttribute("pboard_seq")+"";
				System.out.println("pboard_seq : "+pboard_seq);
				
				//객체에 정보 저장
				BoardVo boardVo = new BoardVo();
				boardVo.setBoard_seq(1);//게시글번호
				boardVo.setPboard_seq(Integer.parseInt(pboard_seq));//부모게시판 번호
				boardVo.setBoard_pseq(1);//부모게시글 번호
				boardVo.setBoard_title(board_title);
				boardVo.setBoard_content(board_content);
				boardVo.setBoard_del("yes");
				boardVo.setBoard_group(0);
				boardVo.setBoard_hit(0);
				Date sysDate = new Date(1999, 4, 22);
				boardVo.setBoard_reg_dt(sysDate);
				//boardVo.setBoard_reg_dt(board_reg_dt);
				boardVo.setBoard_reg_id((String)session.getAttribute("mem_id"));
				boardVo.setBoard_reply(0);
				
				////
				
				
				
				
				//서비스 객체
				BoardServiceInf service = BoardService.getInstance();
				service.boardInsert(boardVo);
				//서비스에서 pboard_seq번호 리스트 가져오기
				
				List<BoardVo> boardList = service.getBoardList(pboard_seq);
				request.setAttribute("boardList", boardList);
			
	}

}
