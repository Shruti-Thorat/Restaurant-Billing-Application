package examRepository;

import examModel.QuestionModel;

public class QuestionRepository extends DBConfig {
	int questionId;
	private int getQuestionId() {
		try {
			st = con.prepareStatement("select max(qid) from question");
			rs = st.executeQuery();
			if(rs.next()) {
				questionId=rs.getInt(1);
			}
			questionId++;
		}catch(Exception e) {
			System.out.println("Error: "+e);
			return 0;
		}
		return questionId;
	}
	
	public int getSubjectIdbyName(String name) {
		try {
			st=con.prepareStatement("select sid from subject where sname=?");
			st.setString(1, name);
			rs = st.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}else {
				return -1;
			}
		}catch(Exception e) {
			System.out.println("Error: "+e);
			return 0;
		}
	}
	
	public boolean isAddQuestion(QuestionModel qModel,String subName) {
		try {
			int qid = this.getQuestionId();
			if(qid!=0) {
				st=con.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
				st.setInt(1, qid);
				st.setString(2, qModel.getName());
				st.setString(3, qModel.getOp1());
				st.setString(4, qModel.getOp2());
				st.setString(5, qModel.getOp3());
				st.setString(6, qModel.getOp4());
				st.setInt(7, qModel.getAnswer());
				int val=st.executeUpdate();
				if(val>0) {
					int sid=this.getSubjectIdbyName(subName);
					if(sid==1) {
						st=con.prepareStatement("insert into subjectquestionjoin values(?,?)");
						st.setInt(1, sid);
						st.setInt(2, qid);
						return st.executeUpdate()>0?true:false;
					}else if(sid==-1) {
						System.out.println("Subject not found");
						return false;
					}
				}else {
					return false;
				}
			}
			return true;
		}catch(Exception e) {
			System.out.println("Error: "+e);
			return false;
		}
	}
}
