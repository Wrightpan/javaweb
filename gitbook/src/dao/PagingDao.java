package dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Paging;
/**
 * Servlet implementation class PagingDao
 */
@WebServlet("/PagingDao")
public interface PagingDao  {
	
   
    Integer getCountRecord();
   
    List<Paging> findIimitPage(Integer newPage);
    
    Integer getCountPage();

}
