package examClient;
import java.util.*;

import examModel.QuestionModel;
import examModel.SubjectModel;
import examServices.QuestionService;
import examServices.SubjectService;

public class ExamApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SubjectService sv = new SubjectService();
		QuestionService qs = new QuestionService();
		char c;
		do {
			System.out.println("1.Add new Subject");
			System.out.println("2.Add Single Question");
			System.out.println("3.Add Multiple questions");
			System.out.println("Enter your Choice");
			int ch = sc.nextInt();
			
			switch(ch) {
			case 1:
				sc.nextLine();
				System.out.println("Enter Subject Name");
				String name = sc.nextLine();
				
				SubjectModel model = new SubjectModel();
				model.setName(name);
				if(sv.addSubject(model)==1) {
					System.out.println("Subject Added Successfully......");
				}else if(sv.addSubject(model)==-1) {
					System.out.println("Subject Already Present");
				}
				else {
					System.out.println("Failed to add Subject");
				}
				break;
				
			case 2:
				sc.nextLine();
				System.out.println("Enter Question");
				String que=sc.nextLine();
				System.out.println("Enter option 1");
				String op1=sc.nextLine();
				System.out.println("Enter option 2");
				String op2=sc.nextLine();
				System.out.println("Enter option 3");
				String op3=sc.nextLine();
				System.out.println("Enter option 4");
				String op4=sc.nextLine();
				System.out.println("Enter option number as answer");
				int ans = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Subject Name");
				String subName = sc.nextLine();
				QuestionModel qModel = new QuestionModel(que,op1,op2,op3,op4,ans);
				if(qs.isAddQuestion(qModel, subName)) {
					System.out.println("Question Added Successfully........");
				}else {
					System.out.println("Failed to add Question");
				}
				break;
				
			case 3:
				sc.nextLine();
				System.out.println("Enter Subject Name");
				String subname = sc.nextLine();
				qs.uploadBulkQuestions(subname);
				break;
				
			default:
				System.out.println("Wrong Choice");
			}
			System.out.println("Do you want to Continue?Enter y or Y");
			c = sc.next().charAt(0);
			
		}while(c=='y' || c=='Y');
	}

}
