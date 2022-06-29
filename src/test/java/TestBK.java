import org.junit.Test;
import top.xin1901.os.device.Vector;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeYunjia
 */
public class TestBK {

    @Test
    public void test1() {
        Vector vector = new Vector();
        System.out.println(vector);
    }

    @Test
    public void test2() {
        Map<Integer, String> map = new HashMap<>();
        map.put(10000, "edge");
//        map.put(10000, "edge");
        System.out.println(map);
    }
}
