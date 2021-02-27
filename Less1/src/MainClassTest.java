import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {

    @Test
    public void testGetClassNumber() {
        int classNumber = this.getClassNumber();
        System.out.println(classNumber);
        Assert.assertFalse("значение должно быть больше 45", classNumber > 45 );
    }
}
