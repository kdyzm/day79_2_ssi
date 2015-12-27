package com.kdyzm.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kdyzm.dao.StudentDao;
import com.kdyzm.domain.Student;

public class SpringTest {
	/**
	 * java.lang.AbstractMethodError: org.mybatis.spring.transaction.SpringManagedTransactionFactory.newTransaction(Ljava/sql/Connection;)Lorg/apache/ibatis/transaction/Transaction;
	 * 
	 * 
	 * 出现了这个错误，直接将mybatics-spring-1.0.0.jar包替换成为mybatics-spring-1.1.1.jar包即可
	 */
	private static ApplicationContext context;
	static{
		context=new ClassPathXmlApplicationContext("beans.xml");
	}
	@Test
	public void test1(){
		StudentDao dao=(StudentDao) context.getBean("studentDao");
		System.out.println(dao);
		Student student=dao.selectStudentById(1);
		System.out.println(student);
		System.out.println(student.getClazz());
	}
	@Test
	public void test2(){
		StudentDao dao=(StudentDao) context.getBean("studentDao");
		List<Student> list=dao.selectAllStudents();
		for(Student student:list){
			System.out.println(student);
		}
	}
}
