import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {

    @Test
    public void testGetLocalNumber() {
        int localNumber = this.getLocalNumber();
        Assert.assertTrue("значение должно быть равно 14", localNumber == 14 );
    }


}
