package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PagingDaoImpl;
import domain.Paging;
@WebServlet(name="PagingServlet", urlPatterns={"/PagingServlet"})
public class PagingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("doget");
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       // System.out.println("dopost");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String npage = request.getParameter("newPage");
       // System.out.println("npage="+npage);
        PagingDaoImpl pageService=new PagingDaoImpl();
        List<Paging> entities = pageService.findIimitPage(new Integer(npage));
        int countRecord = pageService.getCountRecord();
        int countPage = pageService.getCountPage();
        request.setAttribute("entities", entities);
        request.setAttribute("countPage", countPage);
        request.setAttribute("newPage", npage);
        request.setAttribute("countRecord", countRecord);
        request.getRequestDispatcher("/shop-list.jsp").forward(request, response);
    }
}
