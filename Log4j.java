package DemoForLog4j;

import org.apache.logging.log4j.*;
import org.testng.annotations.Test;

public class Log4j {
	private static Logger demoLogger = LogManager.getLogger(Log4j.class.getClass());

	@Test
	public void demo() {
		
		demoLogger.info("Info Logger");		
		demoLogger.error("error Logger");
		demoLogger.debug("debug Logger");
		demoLogger.fatal("Fatal Logger");
		demoLogger.info("Info Logger");		
		demoLogger.error("error Logger");
		demoLogger.debug("debug Logger");
		demoLogger.fatal("newFatal2 Logger");		
		
		
	}
}
