package week4;

public class DynamicBinding2 {
	public static void computeAllGrades(Student[] studentList) {
		for (Student s : studentList) {
				if (s != null) {
				s.computeGrade();
				System.out.println(s.getGrade());
			}
		}
	}

	public static void main(String[] args) {
		Student[] stu = new Student[5];
		stu[0] = new Student("Eula", new int [] {90, 94, 99}, "none");
		stu[1] = new UnderGrad("Klee", new int [] {65, 65, 65}, "none");
		stu[2] = new GradStudent("Diona", new int [] {70, 70, 70}, "none", 1234);
		
		computeAllGrades(stu);
	}

}
