package com.yijie.manager.client.DataClientFall;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yijie.manager.client.daoClient.AdcolumnDao;
import com.yijie.manager.client.daoClient.ProjectDao;
import com.yijie.manager.client.model.Adcolumn;
import com.yijie.manager.client.model.ProjectDesign;
import com.yijie.manager.client.model.Projects;

@Component
public class AdcolumnDaoClientFallBack implements AdcolumnDao {

	@Override
	public List<Adcolumn> adcolumnSelect(Adcolumn adcolumn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer adcolumnDelete(Adcolumn adcolumn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer adcolumnUpdate(Adcolumn adcolumn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer adcolumnInsert(Adcolumn adcolumn) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
