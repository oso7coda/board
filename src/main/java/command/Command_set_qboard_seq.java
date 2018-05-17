package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Command_set_qboard_seq implements CommandInf{

	@Override
	public void excute(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		String pboard_seq = request.getParameter("pboard_seq");
		request.setAttribute("pboard_seq", pboard_seq);
		
			
	}

}
