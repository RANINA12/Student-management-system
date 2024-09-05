package student.mgmt.ddl;

import student.mgmt.dao.StudentDao;
import student.mgmt.dao.StudentDaoImpl;

public class Ex01CreateSchema {

	public static void main(String[] args) {
		StudentDao employeeDao = new StudentDaoImpl();
		try {
			employeeDao.createSchema();
			System.out.println("\n Schema create successfully");
		} catch (Exception e) {
			System.out.println("\n Schema creation failed");
			e.printStackTrace();
		}

	}

}
