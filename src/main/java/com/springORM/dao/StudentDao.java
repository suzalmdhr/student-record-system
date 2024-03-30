package com.springORM.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springORM.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	@Transactional
	public int insert(Student student) {
		
		int r=(int) this.hibernateTemplate.save(student);
		return r;
		
	}
	
	
		public Student getStudent(int studentId) {
			
		Student studs=	this.hibernateTemplate.get(Student.class, studentId);
			
			return studs;
		}
		
		
		public List<Student> getAllStudents(){
			
			
			List<Student> studs = this.hibernateTemplate.loadAll(Student.class);
			return studs;
		}
		
		
		@Transactional
		public void delete(int studentId) {
			
		Student studs=	this.hibernateTemplate.get(Student.class, studentId);
			this.hibernateTemplate.delete(studs);
			
		}
		
			@Transactional
			public void update(Student student) {
				
		 this.hibernateTemplate.update(student);

				
			}
		
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
