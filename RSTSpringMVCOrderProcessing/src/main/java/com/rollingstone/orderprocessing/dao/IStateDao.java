package com.rollingstone.orderprocessing.dao;

import java.util.List;

import com.rollingstone.orderprocessing.model.State;

public interface IStateDao {

	List<State> getAllStates();
	
}
