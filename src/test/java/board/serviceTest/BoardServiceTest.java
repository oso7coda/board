package board.serviceTest;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.model.BoardVo;
import board.service.BoardService;
import board.service.BoardServiceInf;

public class BoardServiceTest {

	@Test
	public void test() {
		/***Given***/
		BoardServiceInf service= BoardService.getInstance();

		/***When***/
		//String mem_id="";
		//int res = service.memberLogin(mem_id);
		Map<String , String> loginInfo = new HashMap<String, String>();
		loginInfo.put("mem_id", "brown");
		loginInfo.put("mem_pass", "123");
		int res = service.memberLogin(loginInfo);

		/***Then***/
		assertNotNull(res);
		assertEquals(1, res);
	}

	
	/**
	 * 
	* Method : boardInsertTest
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.Y.R"
	* 변경이력 :
	* Method 설명 : board에 더미넣기
	 */
	@Test
	public void boardInsertTest() {
		/***Given***/
		BoardDaoInf dao =BoardDao.getInstance();
			
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_seq(1);//게시글번호
		boardVo.setPboard_seq(2);//부모게시판 번호
		boardVo.setBoard_pseq(2);//부모게시글 번호
		boardVo.setBoard_title("테스트용입니다.");
		boardVo.setBoard_content("2게시판 내용 :");
		boardVo.setBoard_reg_id("brown");
		
		Date sysDate = new Date(1999, 4, 22);
		boardVo.setBoard_reg_dt(sysDate);
		boardVo.setBoard_del("yes");
		boardVo.setBoard_reply(0);//댓글갯수
		boardVo.setBoard_hit(0);//조회수
		boardVo.setBoard_group(0);//그룹
		
		
		
		
		
		/***When***/
		int res = dao.insertBoard(boardVo);
//		
//		
//		/***When***/
//		String mem_id="";
//		
//		/***Then***/
		assertNotNull(res);
		assertEquals(1, res);
	}
}
