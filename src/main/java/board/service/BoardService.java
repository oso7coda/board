package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.model.BoardVo;
import board.model.PboardVo;
import board.model.ReplyVo;

public class BoardService implements BoardServiceInf {

	private static BoardServiceInf service = new BoardService();
	private BoardDaoInf dao;
	
	private BoardService() {
		dao=BoardDao.getInstance();
	}

	public static BoardServiceInf getInstance() {
		return service;
	}

	@Override
	public int memberLogin(Map<String, String> loginInfo) {
		return dao.memberLogin(loginInfo);
	}

	@Override
	public List<PboardVo> pboardList(String pboard_reg_id) {
		return dao.pboardList(pboard_reg_id);
	}

	@Override
	public int deletePboard(String pboard_seq) {
		return dao.deletePboard(pboard_seq);
	}

	@Override
	public int updatePboard(String pboard_seq) {
		return dao.updatePboard(pboard_seq);
	}

	@Override
	public int createPboard(PboardVo pboardVo) {
		return dao.createPboard(pboardVo);
	}

	@Override
	public List<BoardVo> getBoardList(String pboard_seq) {
		return dao.getBoardList(pboard_seq);
	}

	@Override
	public int boardInsert(BoardVo boardVo) {
		return dao.insertBoard(boardVo);
	}

	@Override
	public int getBoardMaxNum(String pboard_seq) {
		return dao.getBoardMaxNum(pboard_seq);
	}

	@Override
	public Map<String, Object> getBoardList(Map<String, Integer> pageMap) {
		Map<String, Object> resMap = new HashMap<String, Object>();
//		List<BoardVo> boardList = null;
//		boardList = (List<BoardVo>) dao.getBoardList(pageMap);
//		String pboard_seq = pageMap.get("pboard_seq")+"";
//		int totalCnt = dao.getBoardMaxNum(pboard_seq);
//		
//		String pageNav = makePageNav((int)resMap.get("page"),totalCnt,(int)resMap.get("pboard_seq"));
				return resMap;
	}

	private String makePageNav(int page, int totalCnt, int pboard_seq) {
		int pageTotalCnt = (int)Math.ceil((double)totalCnt/10);
		
		StringBuffer pageNav = new StringBuffer();
		pageNav.append("<nav>");
		pageNav.append("	<ul class=\"pagination\">");
		pageNav.append("		<li><a href=board.do?page=1&pageSize=10' aria-label=\"Previous\"> <span");
		pageNav.append("		aria-hidden=\"true\">&laquo;</span>");
		pageNav.append("		</a></li>");
		for (int i = 1; i <= pageTotalCnt; i++) {
			if(i==page) {
				pageNav.append("			<li class=\"active\"> <a href=\"board.do?pboard_seq=" + pboard_seq +"&page="+i+ "&pageSize=10\">"+i+"</a></li>");
			}else {
				pageNav.append("			<li> <a href=\"board.do?pboard_seq=" + pboard_seq +"&page="+i + "&pageSize=10\">"+i+"</a></li>");
			}
		}
		pageNav.append("			<li><a href=\"board.do?pboard_seq="+pboard_seq +"&page="+pageTotalCnt+"&pageSize=10\" aria-label=\"Next\"> <span");
		pageNav.append("		aria-hidden=\"true\">&raquo;</span>");
		pageNav.append("		</a></li>");
		pageNav.append("	</ul>	");
		pageNav.append("</nav>	");
			
		return pageNav.toString();
	}

	@Override
	public BoardVo getBoardVo(int board_seq) {
		return dao.getBoardVo(board_seq);
	}

	@Override
	public List<ReplyVo> getReplyVo(int board_seq) {
		return dao.getReplyVo(board_seq);
	}

	@Override
	public int replyInsert(ReplyVo replyVo) {
		return dao.replyInsert(replyVo);
	}

	@Override
	public int replyDelete(ReplyVo replyVo) {
		return dao.replyDelete(replyVo);
	}

	@Override
	public int boardUpdate(BoardVo boardVo) {
		return dao.boardUpdate(boardVo);
	}
	
	


}
