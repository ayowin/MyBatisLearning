package wz.mybatis.manual;

public class User {
    
    private int id;
    private String username;
    private String password;
    private String identityCard;
    private String phoneNumber;
    private String job;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getIdentityCard() {
        return identityCard;
    }
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
 
}
