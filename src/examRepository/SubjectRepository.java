package examRepository;

import java.sql.SQLException;
import java.util.*;

import examModel.SubjectModel;

public class SubjectRepository extends DBConfig{
	
	List<String> list = new ArrayList<String>();
	
	public boolean isAddSubject(SubjectModel model) {
		try {
			st = con.prepareStatement("insert into subject values(0,?)");
			st.setString(1, model.getName());
			int value = st.executeUpdate();
			if(value>0) {
				return true;
			}else {
				return false;
			}
			
			
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return false;
	}
	
	public boolean isSubjectPresent(String subName) {
		try {
			st = con.prepareStatement("select * from subject where sname=?");
			st.setString(1, subName);
			rs = st.executeQuery();
			return rs.next();
		} catch (Exception e) {
			System.out.println("Error: "+e);
			return false;
		}
		
	}
	
	public List<String> getAllSubjects(){
		try {
			st=con.prepareStatement("select sname from subject");
			rs=st.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			return list.size()>0?list:null;
		}catch(Exception e) {
			System.out.println("Error: "+e);
			return  null;
		}
	}
}
