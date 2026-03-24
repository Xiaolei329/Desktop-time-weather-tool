import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author Penghui Lei
 * @version 11.0
 * @Title GUI_Test.java
 * @Package PACKAGE_NAME
 * @date 2024/5/6
 */

public class test
{
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("shutdown -a");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
