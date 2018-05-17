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

public class CommanReplyDelete implements CommandInf {

	@Override
	public void excute(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
		//서비스 객체
		BoardServiceInf service = BoardService.getInstance();
		
		//리플객체 생성
		ReplyVo replyVo = new ReplyVo();
		String board_seq = request.getParameter("board_seq");
		String reply_seq = request.getParameter("reply_seq");
		String reply_del = request.getParameter("reply_del");
		
		//리플에 내용담기
		//리플 시퀀시
		replyVo.setReply_seq(Integer.parseInt(reply_seq));
		//수정
		if(reply_del.equals("yes")){
			replyVo.setReply_del("del");
		}else {
			replyVo.setReply_del("yes");
		}
		
		service.replyDelete(replyVo);
		request.setAttribute("board_seq", board_seq);
	}

}
