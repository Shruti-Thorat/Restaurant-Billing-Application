package examRepository;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.*;

import helper.PathHelper;

public class DBConfig {
	
	protected Connection con;
	protected PreparedStatement st;
	protected ResultSet rs;
	
	public DBConfig() {
		try {
			PathHelper phelp = new PathHelper();
			Class.forName(PathHelper.p.getProperty("driver"));
			con = DriverManager.getConnection(PathHelper.p.getProperty("url"),PathHelper.p.getProperty("user"),PathHelper.p.getProperty("pass"));
			
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
	
}
