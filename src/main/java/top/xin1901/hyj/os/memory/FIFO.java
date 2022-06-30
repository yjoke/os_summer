package top.xin1901.hyj.os.memory;

import java.util.Deque;
import java.util.List;
import java.util.Optional;

/**
 * @author HeYunjia
 */
public class FIFO extends MemoryManage {

    /**
     * FIFO 类队列
     */
    private final Deque<Integer> queue;

    public FIFO() {
        queue = table;
    }

    public FIFO(List<Integer> list) {
        this();
        this.list = list;
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
