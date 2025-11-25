package cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentCrudApp {
private static final String URL="jdbc::mysql://localhost::3306/School";
private static final String USER="root";
private static final String PASSWORD="cdacacts";
private Connection conn;
public void StudentCrupApp() {
	try {
		conn=DriverManager.getConnection(URL,USER,PASSWORD);
		System.out.println("Database Connected Successfully!");
	
	}catch(SQLException e) {
		System.out.println("Connection failed");
	}
}
public void insertStudent() {
	Scanner sc=new Scanner(System.in);
	try {
		String sql="insert into student(id,name,age,course)values(?,?,?,?)";
				PreparedStatement pst=conn.prepareStatement(sql);
				System.out.println("enter student Id:");
				pst.setInt(1,sc.nextInt());
				sc.nextLine();
				System.out.println("enter name:");
				pst.setString(2,sc.nextLine());
				System.out.println("enter age:");
				pst.setInt(3,sc.nextInt());
				sc.nextLine();
				System.out.println("enter course:");
				pst.setString(4,sc.nextLine());
				
				int rows=pst.executeUpdate();
				System.out.println("student inserted("+rows+"row(s)affected");
	
				
	}catch(SQLException e) {
		System.out.println("error inserting student:"+e.getMessage());
}
}

public void updateStudent() {
	Scanner sc=new Scanner(System.in);
	try {
		String sql="update student set name=?,age=?,course=? where id=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		System.out.println("enter student id to update:");
		pst.setInt(4,sc.nextInt());
		sc.nextLine();
		System.out.println("enter new name:");
		pst.setString(1,sc.nextLine());
		System.out.println("enter new age:");
		pst.setInt(2,sc.nextInt());
		sc.nextLine();
		System.out.println("enter new course:");
		pst.setString(3,sc.nextLine());
		int rows=pst.executeUpdate();
		System.out.println("updated successfully");
		
	}catch(SQLException e) {
		System.out.println("error updating student:"+e.getMessage());
		
	}
}
 
public void deleteStudent() {
	Scanner sc=new Scanner(System.in);
	try {
		String sql="delete from student where id=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		System.out.println("enter student id to delet:");
		pst.setInt(1,sc.nextInt());
		int rows=pst.executeUpdate();
		System.out.println("deleted successfully");
		
	}catch (SQLException e) {
		System.out.println("error deleting student:"+e.getMessage());
		
	}
}

public void selectStudent() {
	Scanner sc=new Scanner(System.in);
	try {
		String sql="select *from student where id=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		System.out.println("enter student id:");
		pst.setInt(1,sc.nextInt());
		
		ResultSet rs=pst.executeQuery();
		if(rs.next()) {
			System.err.println("\n....Student Details...");
			System.out.println("ID:"+rs.getInt("id"));
			System.out.println("Name:"+rs.getString("name"));
			System.out.println("Age:"+rs.getInt("age"));
			System.out.println("Course:"+rs.getString("course"));
			System.out.println("------------------------------------------------");
			
		}else {
			System.out.println("No student found");
		}
	}catch(SQLException e) {
		System.out.println("error fetching student:"+e.getMessage());
		
	}
		
	}

public void selectAllStudents() {
	try {
		String sql="select *from student";
		PreparedStatement pst=conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		System.out.println("\n-----All Student----");
		while(rs.next()) {
			System.out.println(
					rs.getInt("id")+"|"+
			rs.getString("name")+"|"+
							rs.getInt("age")+"|"+
			rs.getString("course")
							);
			System.out.println("------------------");
		}catch(SQLException e) {
			System.out.println("error fetching records:"+e.getMessage());
			
		}
	}
	
	public void start() {
		Scanner sc=new Scanner(System.in);

        while (true) {
            System.out.println("\n====== STUDENT CRUD MENU ======");
            System.out.println("1. Insert Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View Student by ID");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: insertStudent(); break;
                case 2: updateStudent(); break;
                case 3: deleteStudent(); break;
                case 4: selectStudent(); break;
                case 5: selectAllStudents(); break;
                case 6:
                    System.out.println("👋 Exiting Program...");
                    return;
                default:
                    System.out.println("❌ Invalid Choice!");
            }
        }
    }

    public static void main(String[] args) {
        StudentCrudApp app = new StudentCrudApp();
        app.start();
    }
}

	
