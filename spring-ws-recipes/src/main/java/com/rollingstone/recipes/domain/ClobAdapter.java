package com.rollingstone.recipes.domain;

import java.sql.Clob;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.exolab.castor.mapping.FieldHandler;
import org.exolab.castor.mapping.ValidityException;

public class ClobAdapter extends XmlAdapter<String, Clob> implements FieldHandler{

	Clob clob = null;
    @Override
    public Clob unmarshal(String v) throws Exception {
    	long position = 1;
    	clob.setString(position, v);
    	return clob;
    }

    @Override
    public String marshal(Clob v) throws Exception {
    	return v.toString();
    }

	@Override
	public void checkValidity(Object arg0) throws ValidityException,
			IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValue(Object arg0) throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object newInstance(Object arg0) throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetValue(Object arg0) throws IllegalStateException,
			IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValue(Object arg0, Object arg1)
			throws IllegalStateException, IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

}