package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DataSourceUtils;
import domain.Paging;

public class PagingDaoImpl implements PagingDao {

    private static final Integer pageSize = 5;
    private Integer countRecord;
    private Integer countPage;


    private static Connection conn= DataSourceUtils.getConnection();;
    private PreparedStatement pstmt;
    private ResultSet rs;

   
    public Integer getCountRecord() {
        
        Integer count = 0;
       
        String sql = "select count(*) as con from products";

        try {
            
            pstmt = conn.prepareStatement(sql);
            
            rs = pstmt.executeQuery();
           
            if (rs.next()) {
                count = rs.getInt("con");
            }
           
            this.countPage = ((count % pageSize) != 0 ? (count / pageSize + 1): (count / pageSize));
           
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }

        return count;
    }

    
    public Integer getCountPage() {
        
        return countPage;
    }

    
    public List<Paging> findIimitPage(Integer newPage) {
        
        List<Paging> entities = new ArrayList<Paging>();
        
        String sql = "select * from products limit ?,?";
        try {
            
            pstmt = conn.prepareStatement(sql);
            
            int index = 1;
            pstmt.setObject(index++, (newPage - 1) * pageSize);
            pstmt.setObject(index++, pageSize);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Paging entity = new Paging();
                entity.setId(rs.getInt("id"));
                entity.setName(rs.getString("name"));
                entity.setPrice(rs.getDouble("price"));
                entity.setCategory(rs.getString("category"));
                entity.setNum(rs.getInt("num"));
                entity.setImgurl(rs.getString("imgurl"));
                entity.setDescription(rs.getString("description"));
            
                entities.add(entity);
            }
            
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return entities;
    }
}