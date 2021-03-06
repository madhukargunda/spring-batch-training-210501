package study.pattern.training.dataprocessing.processor;

import org.springframework.batch.item.ItemProcessor;

import study.pattern.training.dataprocessing.model.Student;


/**
 *    			  Criteria 1: score= above 70 and grade=A ,result=PASS
        	      Criteria 2: score=below 70 and grade=A , result=PASS
        	      Criteria 3: score=below 70 and grade not A , result=FAIL
 * 
 * @author madhukargunda
 *
 */
public class StudentDataResultsItemProcessor implements ItemProcessor<Student, Student> {

	@Override
	public Student process(Student student) throws Exception {
        System.out.println("Student Records are prcessing........................");
		Student stu = new Student();
		stu.setRollnumber(student.getRollnumber());
		stu.setName(student.getName());
		stu.setMarks(student.getMarks());
		stu.setGrade(student.getGrade());
		
	   if((student.getMarks()>=70 || student.getMarks()<=70) && student.getGrade().equalsIgnoreCase("A")){
		   stu.setResult(true);
	   } else
		   stu.setResult(false);
		System.out.println("After Processing the Student Records " +stu);		
		return stu;
	}

}
