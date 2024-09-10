package examServices;
import java.util.*;

import examModel.SubjectModel;
import examRepository.SubjectRepository;

public class SubjectService {
	SubjectRepository sr = new SubjectRepository();
	
	public int addSubject(SubjectModel model) {
		if(sr.isSubjectPresent(model.getName())) {
			return -1;
		}else {
			return sr.isAddSubject(model)?1:0;
		}
		
	}
	
	public List<String> getAllSubjects(){
		return this.sr.getAllSubjects();
	}
}
