package command.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.ReplyVo;
import board.service.BoardService;
import board.service.BoardServiceInf;
import command.CommandInf;

public class CommanReplyInsert implements CommandInf {

	@Override
	public void excute(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		//서비스 객체
		BoardServiceInf service = BoardService.getInstance();
		
		//리플객체 생성
		ReplyVo replyVo = new ReplyVo();
		String board_seq = request.getParameter("board_seq");
		String reply_content = request.getParameter("reply_content");
		
		//리플에 내용담기
		replyVo.setReply_board_seq(Integer.parseInt(board_seq));
		replyVo.setReply_content(reply_content);
		replyVo.setReply_mem_id(session.getAttribute("mem_id")+"");
		replyVo.setReply_del("yes");
		
		service.replyInsert(replyVo);
		
		request.setAttribute("board_seq", board_seq);
	}

}
