package com.kdyzm.dao;

import java.io.Serializable;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kdyzm.domain.Clazz;

@Repository("clazzDao")
public class ClazzDao {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;

	public Clazz getClazzById(Serializable id) {
		String statement="com.kdyzm.domain.Clazz.selectClazzByIdNotWithStudents";
		return this.sessionTemplate.selectOne(statement, id);
	}

}
