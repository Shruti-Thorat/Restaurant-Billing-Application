package examServices;

import java.io.*;
import examModel.QuestionModel;
import examRepository.QuestionRepository;
import java.util.*;

public class QuestionService {
	QuestionRepository qRepo = new QuestionRepository();
	SubjectService ss = new SubjectService();
	
	public boolean isAddQuestion(QuestionModel qModel,String subName) {
		return qRepo.isAddQuestion(qModel, subName);
	}
	
	public boolean createFiles() {
		try {
			String path = "C:\\Users\\shrut\\OneDrive\\Documents\\JavaProjectFiles\\QuestionBank";
			File f = new File(path);
			if(!f.exists()) {
				f.mkdir();
			}
			List<String> subList = ss.getAllSubjects();
			if(subList!=null) {
				for(String subName:subList) {
					f=new File(path+"\\"+subName+".csv");
//					System.out.println(f);
					if(!f.exists()) {
						f.createNewFile();
					}
				}
			}else {
				System.out.println("Subject not found");
			}
			return true;
		}catch(Exception e) {
			System.out.println("Error: "+e);
			return false;
		}
	}
	
	public boolean uploadBulkQuestions(String subName) {
		boolean b = this.createFiles();
		if(b) {
			File f = new File("C:\\Users\\shrut\\OneDrive\\Documents\\JavaProjectFiles\\QuestionBank");
			File []filelist = f.listFiles();
			boolean flag=false;
			for(File file:filelist) {
				int index = file.toString().indexOf(subName);
				if(index!=-1) {
					flag=false;
					break;
				}
			}
			if(flag) {
				System.out.println("Subject File Found");
			}else {
				System.out.println("Subject file not found");
			}
			return true;
		}else {
			return false;
		}
	}
}
