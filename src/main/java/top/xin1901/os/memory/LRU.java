package top.xin1901.os.memory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author HeYunjia
 */
public class LRU extends MemoryManage {

    /**
     * LRU 类栈
     */
    private final Deque<Integer> stack;

    public LRU() {
        stack = table;
    }

    public LRU(List<Integer> list) {
        this();
        this.list = list;
    }

    @Override
    public Optional<List<Integer>> getNext() {
        if (list.size() == n) return Optional.empty();
        int next = list.get(n++) / pageSize;

        Deque<Integer> backup = new ArrayDeque<>();

        while (!stack.isEmpty()) {
            if (next == stack.peek()) break;
            else backup.push(stack.pop());
        }

        if (stack.isEmpty()) clash += 1;
        else stack.pop();

        if (backup.size() == TableLen) backup.pop();
        while (!backup.isEmpty()) stack.push(backup.pop());
        stack.push(next);

        return Optional.ofNullable(tableToList());
    }

}
