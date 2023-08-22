package com.mystore.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	public static Logger log = LogManager.getLogger(Log.class.getName());

	public static void startTest(String tcName) {

		log.info(
				"================================" + tcName + " Test start===========================================");

	}

	public static void endTest(String tcName) {

		log.info(
				"================================" + tcName + " Test end==============================================");

	}

	public static void info(String msg) {
		log.info(msg);
	}

	public static void warn(String msg) {
		log.warn(msg);
	}
}
