package Selenium.Selenium;

import org.apache.logging.log4j.*;
import org.testng.annotations.Test;

public class log4j {
	private static Logger demoLogger = LogManager.getLogger(log4j.class.getClass());

	@Test
	public void demo() {
		System.out.println("Log;....");
		demoLogger.info("Info Logger");		
		demoLogger.error("error Logger");
		demoLogger.debug("debug Logger");
		demoLogger.fatal("Fatal Logger");
		
	}
}


