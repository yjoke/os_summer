import org.junit.Test;

import java.util.*;

/**
 * @author HeYunjia
 */
public class TestUse {

    @Test
    public void test1() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
            System.out.println(stack.poll());
        }
    }

    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(7);
        list.add(9);
        System.out.println(Collections.binarySearch(list, 3));
        System.out.println(Collections.binarySearch(list, 5));
        System.out.println(Collections.binarySearch(list, 8));

        Deque<Integer> queue = new ArrayDeque<>(list);

        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }
}
