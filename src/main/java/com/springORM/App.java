package com.springORM;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springORM.dao.StudentDao;
import com.springORM.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
        
        StudentDao studentDao = ctx.getBean("studentDao",StudentDao.class);
        
        
//        
        
        boolean go=true;
        Scanner scan=new Scanner(System.in);
        
        
        while(go) {
    	System.out.println("Press 1 to add new student");
    	System.out.println("Press 2 to display all students");
    	System.out.println("Press 3 to display single student detail");
    	System.out.println("Press 4 to delete student detail");
    	System.out.println("Press 5 to update student detail");
    	System.out.println("Press 6 to exit");
    	
    	
    	
    		try {
    				int input=scan.nextInt();
    				
    				
    				switch (input) {
					case 1:
						
						System.out.println("Enter id");
						int id=scan.nextInt();
						System.out.println("Enter city");
						String city=scan.next();
						System.out.println("Enter name");
						String name=scan.next();
						
						
						Student studs=new Student();
						studs.setStudentId(id);
						studs.setStudentCity(city);
						studs.setStudentName(name);
						
						studentDao.insert(studs);
						
						System.out.println("inserted");
						break;
						
						
					case 2:
						
						List<Student> studes = studentDao.getAllStudents();
						
						for(Student st:studes) {
							System.out.println("*******************************");
							System.out.println("Id   : "+st.getStudentId());
							System.out.println("Name : "+st.getStudentName());
							System.out.println("City : "+st.getStudentCity());
							System.out.println("*********************************");
						}
						
						
						break;
						
						
					case 3:
						
						System.out.println("Enter id of a student");
						int sid=scan.nextInt();
						
					Student student=	studentDao.getStudent(sid);
					System.out.println("Name is : "+student.getStudentName());
					System.out.println("City is : "+student.getStudentCity());
						
						break;
						
						
						
						
					case 4:	
						System.out.println("Enter the id you want to delete");
						int ssid=scan.nextInt();

							studentDao.delete(ssid);
							System.out.println("deleted");
						
						break;
						
						
					case 5:
						System.out.println("Enter id that you want to update");
						int upId=scan.nextInt();
						
						
						
						System.out.println("Update your name");
						String upName=scan.next();
						
						System.out.println("Update your city");
						String upCity=scan.next();
						
						
						Student sts=new Student();
						sts.setStudentId(upId);
						sts.setStudentName(upName);
						sts.setStudentCity(upCity);
						
						System.out.println("updated");
						
						break;
					default:
						go=false;
						break;
					}
    			
    			
    		}
    		catch (Exception e) {
				// TODO: handle exception
    			
    			System.out.println("Wrong input");
    			System.out.println(e.getMessage());
			}
    	
        }
        
        System.out.println("Thankyu for using my apps");
        
     
    }
}
