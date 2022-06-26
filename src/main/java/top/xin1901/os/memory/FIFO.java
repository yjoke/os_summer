package top.xin1901.os.memory;

import java.util.*;

/**
 * @author HeYunjia
 */
public class FIFO extends MemoryManage {

    /**
     * FIFO 类队列
     */
    Deque<Integer> queue;

    public FIFO() {
        queue = table;
    }

    @Override
    public Optional<List<Integer>> getNext() {
        if (list.size() == n) return Optional.empty();
        int next = list.get(n++) / pageSize;

        for (Integer tmp : queue) {
            if (next == tmp) return Optional.ofNullable(tableToList());
        }
        clash += 1;

        if (queue.size() == TableLen) queue.poll();
        queue.offer(next);

        return Optional.ofNullable(tableToList());
    }

}
