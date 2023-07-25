/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;



import hr.algebra.model.User;
import hr.algebra.model.UserPackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ivan
 */
public class UserDao {
    private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String username, String password) {
		User user = null;
        try {
            query = "EXEC userLogin\n" +
"		@pLoginName = N'"+username +"',\n" +
"		@pPassword = N'"+password+"'";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("UserID"));
            	user.setUsername(rs.getString("LoginName"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
        public void userRegister(String username, String password, String email, int type, UserPackage userPackage){
            String _package = userPackage.toString();
            try {
            query = "EXEC AddUser\n" +
"		@pLogin = N'"+username+"',\n" +
"		@pPassword = N'"+password+"',\n" +
"		@pEmail = N'"+email+"',\n" +
"		@pType = N'"+type+"',\n" +
"		@pPackage = N'"+_package+"'";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();
            }catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        }
       
}