package top.xin1901.os.file;

import java.util.ArrayDeque;
import java.util.List;

/**
 * @author HeYunjia
 */
public class FCFS extends FileManage {

    public FCFS() {
        super();
    }

    public FCFS(int now, List<Integer> list) {
        super(now, list);
    }

    @Override
    protected void InitQueue() {
        deque = new ArrayDeque<>();
        for (Integer i : list) {
            deque.offer(i);
        }
    }

    @Override
    public Integer next() {
        if (deque.isEmpty()) return null;

        Integer next = deque.poll();

        n += 1;
        sum += Math.abs(now - next);
        now = next;

        return now;
    }
}
