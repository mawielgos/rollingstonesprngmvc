package com.rollingstone.recipes.dao;

import net.sf.ehcache.CacheManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.rollingstone.recipes.utils.HibernateUtil;


public abstract class AbstractDAO {
	/**
	 * Autowired instance of HibernateUtil
	 */
	protected HibernateUtil hbUtil;
	protected CacheManager cacheManager;
	
	public CacheManager getCacheManager() {
		return cacheManager;
	}

	@Autowired
	@Required
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public HibernateUtil getHbUtil() {
		return hbUtil;
	}

	@Autowired
	@Required
	public void setHbUtil(HibernateUtil hbUtil) {
		this.hbUtil = hbUtil;
	}
}
