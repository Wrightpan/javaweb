package mvc;
 
import java.util.List;

import mvc.CriteriaCustomer;
 
public interface CustomerDAO {
 
    public void update(Customer customer);
 
    public static void save(Customer customer) {
		// TODO Auto-generated method stubs
		
	}
 
    public void delete(int id);
 
    public Customer get(int id);
 
    public List<Customer> getAll();
 
    public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);

	public static  long getCountWithName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}
}
