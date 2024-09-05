package student.mgmt.ddl;
import student.mgmt.dao.StudentDao;
import student.mgmt.dao.StudentDaoImpl;
public class Ex02CreateTable {

	public static void main(String[] args) {
		StudentDao employeeDao = new StudentDaoImpl();
		try {
			employeeDao.createTable();
			System.out.println("\n Table create successfully");
		} catch (Exception e) {
			System.out.println("\n Table creation failed");
			e.printStackTrace();
		}

	}

}
