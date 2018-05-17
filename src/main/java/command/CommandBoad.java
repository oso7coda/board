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

import board.model.BoardVo;
import board.model.Paging;
import board.service.BoardService;
import board.service.BoardServiceInf;

public class CommandBoad implements CommandInf{

	@Override
	public void excute(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		//게시판 요청번호
		String pboard_seq ="1";
		if(session.getAttribute("pboard_seq")!=null){
			pboard_seq = session.getAttribute("pboard_seq")+"";
		}
		if(request.getParameter("pboard_seq")!=null){
			
			pboard_seq = request.getParameter("pboard_seq")+"";
		}
		
		
		//서비스 객체
		BoardServiceInf service = BoardService.getInstance();
				
		//전체 글갯수
		int totalCount = service.getBoardMaxNum(pboard_seq);
		
		
		//페이지네이션 처리
		int curBlock=0;
		if(request.getParameter("curBlock")!=null){
			curBlock = Integer.parseInt(request.getParameter("curBlock"));
		}
		
		int curPage=0;
		if(request.getParameter("curPage")!=null){
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		
		request.setAttribute("curBlock", curBlock);
		request.setAttribute("curPage", curPage);
		
		
		Paging paging = new Paging();
        paging.setPageNo(1);//시작번호
        paging.setPageSize(10);//한페이지에 출력할 글갯수
        paging.setTotalCount(totalCount);
        
		
		int page =0;
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int pageSize =10;
		if(request.getParameter("pageSize")!=null){
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		
		
		
		request.setAttribute("pboard_seq", pboard_seq);
		session.setAttribute("pboard_seq", pboard_seq);
		
		
		
			
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		int maxSize = 10;
		int startSize = 1;
		
		
//		pageMap.put("page", page);
//		pageMap.put("pageSize", pageSize);
		//pageMap.put("qboard_seq", pboard_seq);
		
		
//		Map<String, Object> resMap = service.getBoardList(pageMap);
//		String pageNav = (String)resMap.get("pageNav");
		//List<BoardVo> boardList= (List<BoardVo>)resMap.get("boardList");
		String boardNum = session.getAttribute("pboard_seq")+"";
		System.out.println(boardNum);
		List<BoardVo> boardList= service.getBoardList(boardNum);
	    
		//db에 전송하기 위한 게시판 번호
		
//		request.setAttribute("pageNav",pageNav);
		request.setAttribute("boardList", boardList);
	}

}
