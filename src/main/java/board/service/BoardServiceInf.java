package board.service;

import java.util.List;
import java.util.Map;

import board.model.BoardVo;
import board.model.PboardVo;
import board.model.ReplyVo;

public interface BoardServiceInf {
	
	/**
	 * 
	* Method : memberLogin
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.Y.R"
	* 변경이력 :
	* @param loginInfo
	* @return 성공하면 1
	* Method 설명 :로그인 메서드
	 */
	public int memberLogin(Map<String, String> loginInfo);
	
	/**
	 * 
	* Method : pboardList
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.Y.R"
	* 변경이력 :
	* @param pboard_reg_id
	* @return
	* Method 설명 :부모 게시판 리스트 
	 */
	public List<PboardVo> pboardList(String pboard_reg_id);

	/**
	 * 
	* Method : deletePboard
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.Y.R"
	* 변경이력 :
	* @param pboard_seq
	* @return
	* Method 설명 : 게시판 비활성화
	 */
	public int deletePboard(String pboard_seq);
	
	/**
	 * 
	* Method : updatePboard
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.Y.R"
	* 변경이력 :
	* @param pboard_seq
	* @return
	* Method 설명 : 게시판 활성화 메서드
	 */
	public int updatePboard(String pboard_seq);

	/**
	 * 
	* Method : createPboard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.Y.R"
	* 변경이력 :
	* @param pboard_name
	* @return
	* Method 설명 : 부모게시판 생성
	 */
	public int createPboard(PboardVo pboardVo);

	/**
	 * 
	* Method : getBoardList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.Y.R"
	* 변경이력 :
	* @param pboard_seq
	* @return
	* Method 설명 : 게시판 목록가져오기
	* 
	 */
	public List<BoardVo> getBoardList(String pboard_seq);

	/**
	 * 
	* Method : boardInsert
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.Y.R"
	* 변경이력 :
	* @param boardVo
	* Method 설명 : 게시판에 글쓰기
	 */
	public int boardInsert(BoardVo boardVo);

	/**
	 * 
	* Method : getBoardMaxNum
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.Y.R"
	* 변경이력 :
	* @param pboard_seq
	* @return
	* Method 설명 : 페이지네이션 맥스값
	 */
	public int getBoardMaxNum(String pboard_seq);


	public Map<String, Object> getBoardList(Map<String, Integer> pageMap);

	/**
	 * 
	* Method : getBoardVo
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.Y.R"
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : 게시글 내용 가져오기
	 */
	public BoardVo getBoardVo(int board_seq);

	/**
	 * 
	* Method : getReplyVo
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.Y.R"
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 :리플 리스트 겟
	 */
	public List<ReplyVo> getReplyVo(int board_seq);

	/**
	 * 
	* Method : replyInsert
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.Y.R"
	* 변경이력 :
	* @param replyVo
	* @return
	* Method 설명 : 리플달기
	 */
	public int replyInsert(ReplyVo replyVo);

	/**
	 * 
	* Method : replyDelete
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.Y.R"
	* 변경이력 :
	* @param replyVo
	* Method 설명 : 댓글 삭제
	 */
	public int replyDelete(ReplyVo replyVo);

	
	
}
