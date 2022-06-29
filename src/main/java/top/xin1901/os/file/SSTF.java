package top.xin1901.os.file;

import java.util.*;

/**
 * @author HeYunjia
 */
public class SSTF extends FileManage {

    /**
     * 辅助栈
     */
    Deque<Integer> stack;

    public SSTF() {
        super();
    }

    public SSTF(int now, List<Integer> list) {
        super(now, list);
    }

    @Override
    protected void InitQueue() {
        stack = new ArrayDeque<>();

        Collections.sort(list);
        for (Integer i : list) {
            if (i < now) stack.push(i);
            else deque.offer(i);
        }
    }

    @Override
    public Integer next() {
        if (deque.isEmpty() && stack.isEmpty()) return null;

        int next;
        if (deque.isEmpty()) next = stack.pop();
        else if (stack.isEmpty()) next = deque.poll();
        else next = Math.abs(deque.peek() - now) < Math.abs(stack.peek() - now) ? deque.poll() : stack.pop();

        n += 1;
        sum += Math.abs(now - next);
        now = next;

        return now;
    }
}
