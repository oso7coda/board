package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandBoad;
import command.CommandInf;
import command.CommandBoardInsert;
import command.CommandLogin;
import command.CommandPboardController;
import command.CommandPboardCreate;
import command.CommandPboardDelete;
import command.CommandPboardUpdate;
import command.Command_set_qboard_seq;
import command.board.CommandBoardRead;
import command.reply.CommanReplyDelete;
import command.reply.CommanReplyInsert;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		goFrontControl(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		goFrontControl(request,response);
	}
	
	private void goFrontControl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//세션가져오기
		HttpSession session = request.getSession();
		
		//세션아이디 저장
//		String mem_id = request.getParameter("mem_id");
//		session.setAttribute("mem_id", mem_id);
		System.out.println(request.getSession().getAttribute("mem_id"));
		String viewPage = null;
		CommandInf comman = null;
		if(session.getAttribute("mem_id")==null){//로그인 확인
			viewPage = "login.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
			
		}else if(session.getAttribute("pboardList")==null){///로그인 확인 
			viewPage = "login.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
			
		}
		String uri = request.getRequestURI();
		System.out.println(uri);
		String conPath = request.getContextPath();
		System.out.println(conPath);
		String com = uri.substring(conPath.length());
		if(com.equals("/main.do")){//메인페이지
			comman= new CommandLogin();
			comman.excute(request, response, session);
			viewPage = "main.jsp";
		}else if(com.equals("/login.do")){//로그인
			viewPage = "login.jsp";
		}else if(com.equals("/pboard.do")){//부모게시판
			viewPage = "pboard.jsp";
		}else if(com.equals("/board.do")){//게시판으로 이동
			comman= new CommandBoad();
			comman.excute(request, response, session);
			viewPage = "board.jsp";
		}else if(com.equals("/insertBoard.do")){//글쓰기 페이지
			comman= new CommandBoardInsert();
			comman.excute(request, response, session);
			viewPage = "board.jsp";
		}else if(com.equals("/pboardControl.do")){//부모게시판 관리 페이지
			comman= new CommandPboardController();
			comman.excute(request, response, session);
			viewPage = "pboardControl.jsp";
		}else if(com.equals("/deletePboard.do")){//부모게시판 삭제하기
			comman= new CommandPboardDelete();
			comman.excute(request, response, session);
			viewPage = "pboardControl.jsp";
		}else if(com.equals("/updatePboard.do")){//부모게시판 수정
			comman= new CommandPboardUpdate();
			comman.excute(request, response, session);
			viewPage = "pboardControl.jsp";
		}else if(com.equals("/createPboard.do")){//부모 게시판 추가 
			comman= new CommandPboardCreate();
			comman.excute(request, response, session);
			viewPage = "pboardControl.jsp";
		}else if(com.equals("/set_qboard_seq.do")){//게시글 쓰기로 이동
			comman= new Command_set_qboard_seq();
			comman.excute(request, response, session);
			viewPage = "insertBoard.jsp";
		}else if(com.equals("/readBoard.do")){//게시글 읽기+리플 읽기
			comman= new CommandBoardRead();
			comman.excute(request, response, session);
			viewPage = "readBoard.jsp";
		}else if(com.equals("/insertReply.do")){//리플 달기
			comman= new CommanReplyInsert();
			comman.excute(request, response, session);
			viewPage = "readBoard.do";
		}else if(com.equals("/replyDelete.do")){//리플 수정
			comman= new CommanReplyDelete();
			comman.excute(request, response, session);
			viewPage = "readBoard.do";
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
	}

}
