package board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.BoardVo;
import board.model.PboardVo;
import board.model.ReplyVo;

public class BoardDao implements BoardDaoInf {
	private static BoardDaoInf dao = new BoardDao();

	private SqlSessionFactory sqlSessionFactory;

	public BoardDao() {
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static BoardDaoInf getInstance() {
		return dao;
	}

	@Override
	public int memberLogin(Map<String, String> loginInfo) {
		int res = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String str = (String)sqlSession.selectOne("board.memberLogin", loginInfo);
		if (str!=null) {
			res = 1;
		}else{
			res=0;
		}
		sqlSession.commit();
		sqlSession.close();
		return res;
	}
	

	@Override
	public List<PboardVo> pboardList(String pboard_reg_id) {
		List<PboardVo> res = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		res = sqlSession.selectList("board.pboardList", pboard_reg_id);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	
	@Override
	public int deletePboard(String pboard_seq) {
		int res = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		res = sqlSession.update("board.deletePboard", pboard_seq);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int updatePboard(String pboard_seq) {
		int res = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		res = sqlSession.update("board.updatePboard", pboard_seq);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int createPboard(PboardVo pboardVo) {
		int res = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		res = sqlSession.insert("board.createPboard", pboardVo);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	//게시글 리스트 출력
	@Override
	public List<BoardVo> getBoardList(String pboard_seq) {
		List<BoardVo> res = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		res = sqlSession.selectList("board.getBoardList", pboard_seq);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	//게시글 추가
	@Override
	public int insertBoard(BoardVo boardVo) {
		int res = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		res = sqlSession.insert("board.insertBoard", boardVo);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int getBoardMaxNum(String pboard_seq) {
		int res = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		res = (int)sqlSession.selectOne("page.getBoardMaxNum", pboard_seq);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}


	@Override
	public Map<String, Object> getBoardList(Map<String, Integer> pageMap) {
		Map<String, Object> res = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		res = sqlSession.selectOne("page.getBoardList", pageMap);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public BoardVo getBoardVo(int board_seq) {
		BoardVo res = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		res = (BoardVo)sqlSession.selectOne("board.getBoardVo", board_seq);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public List<ReplyVo> getReplyVo(int board_seq) {
		List<ReplyVo> res = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		res = sqlSession.selectList("board.getReplyVo", board_seq);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int replyInsert(ReplyVo replyVo) {
		int res = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		res = sqlSession.insert("board.replyInsert", replyVo);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int replyDelete(ReplyVo replyVo) {
		int res = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		res = sqlSession.update("board.replyDelete", replyVo);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int boardUpdate(BoardVo boardVo) {
		int res = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		res = sqlSession.update("board.boardUpdate", boardVo);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}
	

}
