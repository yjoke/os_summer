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

    @Test
    public void test3() {
        Deque<Integer> d = new ArrayDeque<>();

        d.add(1);
        d.add(2);
        System.out.println(d);
        d.offer(3);
        d.push(4);
        System.out.println(d);
    }

    @Test
    public void test4() {
        int len = 10;
        List<Integer> list = new ArrayList<Integer>(){{
            for (int i = 0; i < len; i++) add(0);
        }};
        System.out.println(list);
    }
}
