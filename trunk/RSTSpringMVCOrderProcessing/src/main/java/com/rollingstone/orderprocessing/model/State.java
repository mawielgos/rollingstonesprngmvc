package com.rollingstone.orderprocessing.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "state")
public class State {
	
	long stateId;
	
	String stateName;
	
	String stateShortName;

	public long getStateId() {
		return stateId;
	}

	@XmlElement
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	@XmlElement
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateShortName() {
		return stateShortName;
	}

	@XmlElement
	public void setStateShortName(String stateShortName) {
		this.stateShortName = stateShortName;
	}
	
}
