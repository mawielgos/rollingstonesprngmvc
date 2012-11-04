package com.rollingstone.orderprocessing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.rollingstone.orderprocessing.dao.IStateDao;
import com.rollingstone.orderprocessing.model.State;

@Service
public class StateServiceImpl implements IStateService {

	IStateDao stateDao;
	
	
	public IStateDao getStateDao() {
		return stateDao;
	}


	@Autowired
	@Required
	public void setStateDao(IStateDao stateDao) {
		this.stateDao = stateDao;
	}


	@Override
	public List<State> getAllStates() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public State getState(long stateId) {
		// TODO Auto-generated method stub
		return null;
	}

}
