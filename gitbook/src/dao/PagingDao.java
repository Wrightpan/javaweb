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
	
    //显示总的记录条数
    Integer getCountRecord();
    //根据当前页到结束页的查询
    List<Paging> findIimitPage(Integer newPage);
    //总的页数
    Integer getCountPage();

}
