package com.rollingstone.orderprocessing.service;

import java.util.List;

import com.rollingstone.orderprocessing.model.State;

public interface IStateService {

	List <State> getAllStates();
	
	State getState(long stateId);
}
