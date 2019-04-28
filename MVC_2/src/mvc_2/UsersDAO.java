package mvc_2;


 
import java.util.List;
 
public interface UsersDAO {
 
    public void update(Users Users);
 
    public void save(Users Users);
 
    public void delete(int id);
 
    public Users get(int id);
 
    public List<Users> getAll();
 
 public List<Users> getForListWithCriteriaUsers(CriteriaUsers cc);
}
