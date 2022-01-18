import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCClass {

	String url = new String(), uname = new String(), pass = new String(), query = new String();
	ResultSet rs;
	Connection con;
	Statement st;

	public JDBCClass() {
		try {
			url = "jdbc:mysql://localhost:3306/nikhil";
			uname = "root";
			pass = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, pass);
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	void saveConatct(String a, String b) {
		query = "insert into contacts values ('" + a + "'," + Long.parseLong(b) + ");";
		try {
			st.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	String fetchContact(String a) {
		query = "select mobileno from contacts where contactName='" + a + "'";
		try {
			rs = st.executeQuery(query);
			rs.next();
			return rs.getInt(1) + "";
		} catch (Exception e) {
			// System.out.println(e.getLocalizedMessage());
			return "Contact is not exist.";
		}
	}

	String deleteContact(String a) {
		query = "delete from contacts where contactName='" + a + "';";
		try {
			int t = st.executeUpdate(query);
			if (t == 0)
				return "Contact is not exist.";
			return "Contact Deleted Successfully.";
		} catch (Exception e) {
			return "Contact is not exist.";
		}
	}

	String updateContact(String a,String b,String c)
	{
		query="update contacts set contactName='"+b+"',mobileno="+Long.parseLong(c)+" where contactName='"+a+"';";
		try{
			int t=st.executeUpdate(query);
			if(t==0)
				return "Contact is not exist.";
			return "Contact Updated Successfully.";
		}
		catch(Exception e){
			System.out.println(e.getLocalizedMessage());
			return "Contact is not exist.";
		}
	}
}
