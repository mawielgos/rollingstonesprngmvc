package com.rollingstone.orderprocessing.model.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.rollingstone.orderprocessing.model.State;
import com.rollingstone.orderprocessing.service.IStateService;

public class StateEditor extends PropertyEditorSupport {

    private IStateService stateService;

    @Autowired
    public StateEditor(IStateService stateService) {
        this.stateService = stateService;
    }

    public void setAsText(String text) throws IllegalArgumentException {
        int stateId = Integer.parseInt(text);
        State state = stateService.getState(stateId);
        setValue(state);
    }
}
