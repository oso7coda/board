package command.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardVo;
import board.model.ReplyVo;
import board.service.BoardService;
import board.service.BoardServiceInf;
import command.CommandInf;

public class CommandBoardRead implements CommandInf{

	@Override
	public void excute(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		//서비스 객체얻기
		BoardServiceInf service = BoardService.getInstance();
		int board_seq =0;
		if(request.getParameter("board_seq")!=null){
			board_seq = Integer.parseInt(request.getParameter("board_seq"));
		}
		
		
		
		
		//게시글번호를 가져와서 db에서 해당 board넘버에 맞는 board객체 받아오기
		BoardVo boardVo = service.getBoardVo(board_seq);
		List<ReplyVo> replyVoList = service.getReplyVo(board_seq);
		
		
		//페이지로 보내기
		request.setAttribute("boardVo", boardVo);
		request.setAttribute("replyVoList", replyVoList);
		
		
		
	}

}
