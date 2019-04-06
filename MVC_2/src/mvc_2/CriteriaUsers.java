package mvc_2;
 
public class CriteriaUsers {
 
    private String username;
    private String password;
    
 
    public String getUsername() {
        if(username == null){
            username = "%%";
        }else{
            username = "%" + username + "%";
        }
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        if(password == null){
            password = "%%";
        }else{
            password = "%" + password + "%";
        }
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 

 
    public CriteriaUsers(String username, String password) {
        this.username = username;
        this.password = password;
        
    }
}
