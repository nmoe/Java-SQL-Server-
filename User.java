package hbut.po;

public class User {
    String UserName;
    String UserPwd;
    int UserID;
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    public String getUserPwd() {
        return UserPwd;
    }
    public void setUserPwd(String userPwd) {
        UserPwd = userPwd;
    }
    public int getUserId() {
        return UserID;
    }
    public void setUserId(int ID) {
        this.UserID = ID;
    }
}
