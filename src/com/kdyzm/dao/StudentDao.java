package com.kdyzm.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.kdyzm.domain.Student;

@Repository("studentDao")
public class StudentDao extends SqlSessionDaoSupport {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	public Student selectStudentById(int studentid) {
		Student student=this.sessionTemplate.selectOne("com.kdyzm.domain.Student.selectUserById", studentid);
		return student;
	}

	public List<Student> selectAllStudents() {
		List<Student> list = this.sessionTemplate.selectList("com.kdyzm.domain.Student.selectAllStudent");
		return list;
	}

	public int updateStudent(Student student) {
		String statement="com.kdyzm.domain.Student.updateStudentByCandition";
		return this.sessionTemplate.update(statement, student);
	}

	public int saveStudent(Student student) {
		String statement="com.kdyzm.domain.Student.insertIntoStudent";
		int result=this.sessionTemplate.insert(statement, student);
//		this.sessionTemplate.commit();
		/**
		 * java.lang.UnsupportedOperationException: Manual commit is not allowed over a Spring managed SqlSession
		 */
		return result;
	}

	public int deleteStudent(Student student) {
		String statement="com.kdyzm.domain.Student.deleteUserById";
		return this.sessionTemplate.delete(statement, student.getId());
	}

	public Student getStudentById(Serializable id) {
		String statement="com.kdyzm.domain.Student.selectUserById";
		return this.sessionTemplate.selectOne(statement, id);
	}

	public List<Student> selectStudentsByCandition(Student student) {
		String statement="com.kdyzm.domain.Student.selectAllByCondition";
		return this.sessionTemplate.selectList(statement, student);
	}
}
