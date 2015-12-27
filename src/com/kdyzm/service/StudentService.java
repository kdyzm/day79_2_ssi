package com.kdyzm.service;

import java.io.Serializable;
import java.util.List;

import com.kdyzm.domain.Student;

public interface StudentService {
	public int updateStudent(Student student);
	public int saveStudent(Student student);
	public int deleteStudent(Student student);
	
	public Student getStudentById(Serializable id);
	public List<Student> selectStudentsByCandition(Student student);
}
