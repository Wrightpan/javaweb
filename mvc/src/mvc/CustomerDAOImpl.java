package mvc;
 
import java.util.List;
 
public class CustomerDAOImpl extends DAO<Customer> implements CustomerDAO {
 
    @Override
    public void update(Customer customer) {
    }
    @Override
    public void save(Customer customer) {
        String sql = "INSERT INTO customers(name, address, phone) VALUES(?, ?, ?)";
        update(sql, customer.getName(), customer.getAddress(), customer.getPhone());
    }
 
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM customer WHERE id = ?";
        update(sql, id);
    }
 
    @Override
    public Customer get(int id) {
        String sql = "SELECT id, name, address, phone FROM customers WHERE id = ?";
        return get(sql, id);
    }
 
    @Override
    public List<Customer> getAll() {
        String sql = "SELECT id, name, address, phone FROM customers";
        return getForList(sql);
 
    }

    @Override
    public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
    String sql = "SELECT id, name, address, phone FROM customers WHERE " +
            "name LIKE ? AND address LIKE ? AND phone LIKE ?";
    //修改了CriteriaCustomer的getter()方法，使其返回字符串中有%%（模糊查询）
    //若返回�?�为null，则返回�?%%”， 否则返回"%" + value + "%"
    return getForList(sql, cc.getName(), cc.getAddress(), cc.getPhone());
}
}
