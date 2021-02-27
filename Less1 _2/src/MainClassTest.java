import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {

    @Test
    public void testGetClassString() {
        String class_string = this.getClassString();
        Assert.assertTrue("в строке должно быть значение hello или Hello", class_string.contains("Hello") || class_string.contains("hello") );
    }
}
