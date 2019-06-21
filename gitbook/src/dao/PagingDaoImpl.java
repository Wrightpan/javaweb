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

    private static final Integer pageSize = 5;//ÿҳ��ʾ5������
    private Integer countRecord;// ���ж�������¼
    private Integer countPage;// ���ж���ҳ

//    private static final String URL = "jdbc:MySQL://localhost:3306/echo?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
    private static Connection conn= DataSourceUtils.getConnection();;
    private PreparedStatement pstmt;
    private ResultSet rs;

   
    public Integer getCountRecord() {
        // ���÷���ֵ
        Integer count = 0;
        // ��ȡ����
        // ����sql��� ��ѯ����¼����
        String sql = "select count(*) as con from products";

        try {
            // ����Ԥ�������
            pstmt = conn.prepareStatement(sql);
            // Ϊռλ����ֵ
            // ִ�и������
            rs = pstmt.executeQuery();
            // �ж�
            if (rs.next()) {
                count = rs.getInt("con");
            }
            // �������ҳ��,����getCountPage�����л�ȡ
            this.countPage = ((count % pageSize) != 0 ? (count / pageSize + 1): (count / pageSize));
            // �ͷ���Դ
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

    // �õ��ܵ�ҳ��
    public Integer getCountPage() {
        
        return countPage;
    }

    // ���ݴ���������ֵ������ѯ
    public List<Paging> findIimitPage(Integer newPage) {
        // �޸ķ���ֵ
        List<Paging> entities = new ArrayList<Paging>();
        
        String sql = "select * from products limit ?,?";//����Ϊ(newPage - 1) * pageSize��pageSize
        try {
            // ����Ԥ�������
            pstmt = conn.prepareStatement(sql);
            // Ϊռλ����ֵ
            int index = 1;
            pstmt.setObject(index++, (newPage - 1) * pageSize);
            pstmt.setObject(index++, pageSize);
            // ִ�и���
            rs = pstmt.executeQuery();
            // �ж�
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
            // �ͷ���Դ
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