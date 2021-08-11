import application.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method m, Object[] p){

        logger.info("Start test " + m.getName());
        logger.info("Test start with data: " + Arrays.asList(p));
        logger.info("=================================================================================");
    }

    @AfterMethod
    public void endLogger(Method m){
        logger.info("End of test " + m.getName());
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }
}
