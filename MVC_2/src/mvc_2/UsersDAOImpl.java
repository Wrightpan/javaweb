package mvc_2;
 
import java.util.List;
 
public class UsersDAOImpl extends DAO<Users> implements UsersDAO {
 
    @Override
    public void update(Users Users) {
    }
 
    @Override
    public void save(Users Users) {
        String sql = "INSERT INTO Users(username, password, ) VALUES(?, ?, ?)";
        update(sql, Users.getUsername(), Users.getPassword());
    }
 
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        update(sql, id);
    }
 
    @Override
    public Users get(int id) {
        String sql = "SELECT id, username, password,  FROM users WHERE id = ?";
        return get(sql, id);
    }
 
    @Override
    public List<Users> getAll() {
        String sql = "SELECT id, username, password, FROM users";
        return getForList(sql);
 
    }

@Override
public List<Users> getForListWithCriteriaUsers(CriteriaUsers cc) {
    String sql = "SELECT id, username, password, phone FROM Users WHERE " +
            "username LIKE ? AND password LIKE ?";
    //修改了CriteriaUsers的getter()方法，使其返回字符串中有%%（模糊查询）
    //若返回值为null，则返回“%%”， 否则返回"%" + value + "%"
    return getForList(sql, cc.getUsername(), cc.getPassword());
}


}
