package MVCCases;
 
import java.util.List;
 
public interface CustomerDAO {
 
    public void update(Customer customer);
 
    public static void save(Customer customer) {
		// TODO Auto-generated method stub
		
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
