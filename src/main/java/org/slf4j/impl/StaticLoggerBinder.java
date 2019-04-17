package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;


public class StaticLoggerBinder implements LoggerFactoryBinder {

	private static StaticLoggerBinder instance = new StaticLoggerBinder();

//	public static String REQUESTED_API_VERSION = "1.6.99";  // !final

	public static StaticLoggerBinder getSingleton () {
		return instance;
	}

	public ILoggerFactory getLoggerFactory () {
		return MockitoLoggerFactory.getSingleton();
	}

	public String getLoggerFactoryClassStr () {
		return MockitoLoggerFactory.class.getName();
	}
}
