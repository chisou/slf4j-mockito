package org.slf4j.impl;

import org.mockito.Mockito;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class MockitoLoggerFactory implements ILoggerFactory {

	private static final MockitoLoggerFactory singleton = new MockitoLoggerFactory();

	public static MockitoLoggerFactory getSingleton () {
		return singleton;
	}

	private Map<String,Logger> loggers = new HashMap<String,Logger>();

	public void setLogger ( String name, Logger logger ) {
		loggers.put( name, logger );
	}

	public Logger getLogger ( String name ) {
		Logger logger = loggers.get( name );
		if ( logger == null ) {
			logger = Mockito.mock( Logger.class );
			loggers.put( name, logger );
		}
		return logger;
	}

}
