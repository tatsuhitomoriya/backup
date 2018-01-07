/**
 *
 */

/**
 * @author testuser
 *
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
public class TestUserDAO {
	String name="";
	String password="";
	public void select(String name,String password){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="select * from test_table where user_name=? and password=?";
		try{
			PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void selectAll(){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="select * from test_table";
		try{
			PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void selectByName(String name){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="select * from test_table where user_name=?";
		try{
			PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void selectByPassword(String password) {
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		
		String sql="select * from test_table where password=?";
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,password);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateUserNameByUserName(String oldName,String newName) {
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		
		String sql="update test_table set user_name=? where user_name=?";
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, oldName);
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println(i+"件更新されました");
			}else {
				System.out.println("該当するデータはありませんでした");
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void insert(int user id,String name,String password) {
		DBConnector db=new DBConnector();
		Connector con=db.getConnection();
		
		String sql="insert into test_table values(?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setString(2, name);
			ps.setString(3, password);
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println(i+"件登録されました");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(String name) {
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		
		String sql="delete from test_table where user_name=?";
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, name);
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println(i+"件削除されました");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
