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

    private static final Integer pageSize = 5;//每页显示5条数据
    private Integer countRecord;// 共有多少条记录
    private Integer countPage;// 共有多少页

//    private static final String URL = "jdbc:MySQL://localhost:3306/echo?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
    private static Connection conn= DataSourceUtils.getConnection();;
    private PreparedStatement pstmt;
    private ResultSet rs;

   
    public Integer getCountRecord() {
        // 设置返回值
        Integer count = 0;
        // 获取连接
        // 定义sql语句 查询出记录条数
        String sql = "select count(*) as con from products";

        try {
            // 创建预处理对象
            pstmt = conn.prepareStatement(sql);
            // 为占位符赋值
            // 执行更新语句
            rs = pstmt.executeQuery();
            // 判断
            if (rs.next()) {
                count = rs.getInt("con");
            }
            // 计算出总页数,并从getCountPage方法中获取
            this.countPage = ((count % pageSize) != 0 ? (count / pageSize + 1): (count / pageSize));
            // 释放资源
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

    // 得到总的页数
    public Integer getCountPage() {
        
        return countPage;
    }

    // 根据传过来的数值条件查询
    public List<Paging> findIimitPage(Integer newPage) {
        // 修改返回值
        List<Paging> entities = new ArrayList<Paging>();
        
        String sql = "select * from products limit ?,?";//参数为(newPage - 1) * pageSize和pageSize
        try {
            // 创建预处理对象
            pstmt = conn.prepareStatement(sql);
            // 为占位符赋值
            int index = 1;
            pstmt.setObject(index++, (newPage - 1) * pageSize);
            pstmt.setObject(index++, pageSize);
            // 执行更新
            rs = pstmt.executeQuery();
            // 判断
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
            // 释放资源
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