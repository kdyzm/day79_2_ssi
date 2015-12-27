package com.kdyzm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kdyzm.domain.Clazz;
import com.kdyzm.domain.Student;
import com.kdyzm.service.ClazzService;
import com.kdyzm.service.StudentService;

public class SpringTest2 {
	private static ApplicationContext context;
	static{
		context=new ClassPathXmlApplicationContext("beans.xml");
	}
	@Test
	public void test1(){
		StudentService service=(StudentService) context.getBean("studentService");
		ClazzService clazzService=(ClazzService) context.getBean("clazzService");
		Student student=new Student();
		student.setId(8);
		student.setName("小吧");
		student.setPassword("xiaozhang");
		student.setAge(120);
		Clazz clazz=clazzService.getClazzById(2);
		student.setClazz(clazz);
		int result=service.saveStudent(student);
		System.out.println("执行结果是："+result);
	}
}
