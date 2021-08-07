package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    public MyListener() {
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start finde element by --> " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("The element " + by + " was found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        super.onException(throwable, driver);
        String path = "src/test/screenshots/screen-" + i + ".png";
        HelperBase base = new HelperBase(driver);
        base.takeScreenshot(path);
        logger.info("Screen--> " + path);
        logger.info(throwable.getMessage());
    }
}
