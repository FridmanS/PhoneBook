import org.testng.annotations.Test;

public class SmokeTest extends TestBase{

    @Test(groups = {"web"})
    public void smokeTest(){
        System.out.println("I`m smoke test");
    }
}
