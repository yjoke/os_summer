import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author HeYunjia
 */
public class TestUse {

    @Test
    public void test1() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);

        for (int i = 0; i < 10; i++) {
            System.out.println(stack.poll());
        }
    }
}
