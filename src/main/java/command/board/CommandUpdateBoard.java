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

public class CommandUpdateBoard implements CommandInf {

	@Override
	public void excute(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		
				//서비스 객체얻기
				BoardServiceInf service = BoardService.getInstance();
				
				//삭제된 게시글 번호 받고
				int board_seq =0;
				if(request.getParameter("board_seq")!=null){
					board_seq = Integer.parseInt(request.getParameter("board_seq"));
				}
				
				//게시글번호를 가져와서 db에서 해당 board넘버에 맞는 board객체 받아오기
				String board_del =null;
				if(request.getParameter("board_del")!=null){
					board_del = (String)request.getParameter("board_del");
				}
				
				//board 객체에 글번호와 삭제 활성화 여부 선택
				BoardVo boardVo = new BoardVo();
				boardVo.setBoard_seq(board_seq);
				if(board_del=="no"){
					board_del = "yes";
				}else{
					board_del = "no";
				}
				boardVo.setBoard_del(board_del);
				
				
				int res = service.boardUpdate(boardVo);
		//before
				
		//after
				//수정 이후 처리
				String pboard_seq = (String)session.getAttribute("pboard_seq");
				
				//페이지로 보내기
				List<BoardVo> boardList= (List<BoardVo>)service.getBoardList(pboard_seq);
				
				request.setAttribute("boardList", boardList);

	}
}
