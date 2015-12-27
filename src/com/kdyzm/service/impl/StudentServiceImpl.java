package com.kdyzm.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kdyzm.dao.StudentDao;
import com.kdyzm.domain.Student;
import com.kdyzm.service.StudentService;
@Service("studentService")
public class StudentServiceImpl implements StudentService{
	@Resource(name="studentDao")
	private StudentDao studentDao;
	@Override
	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	@Override
	public int saveStudent(Student student) {
		int result=studentDao.saveStudent(student);
		return result;
	}

	@Override
	public int deleteStudent(Student student) {
		return studentDao.deleteStudent(student);
	}

	@Override
	public Student getStudentById(Serializable id) {
		return studentDao.getStudentById(id);
	}

	@Override
	public List<Student> selectStudentsByCandition(Student student) {
		return studentDao.selectStudentsByCandition(student);
	}

}
