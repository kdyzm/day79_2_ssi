package com.kdyzm.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kdyzm.dao.ClazzDao;
import com.kdyzm.domain.Clazz;
import com.kdyzm.service.ClazzService;
@Service("clazzService")
public class ClazzServiceImpl implements ClazzService{
	@Resource(name="clazzDao")
	private ClazzDao clazzDao;
	@Override
	public Clazz getClazzById(Serializable id) {
		return this.clazzDao.getClazzById(id);
	}

}
