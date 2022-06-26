package top.xin1901.os.memory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author HeYunjia
 */
public class LRU extends MemoryManage {

    /**
     * 存放页表的状态栈
     */
    Deque<Integer> stack;

    public LRU() {
        stack = status;
    }

    @Override
    public Optional<List<Integer>> getNext() {
        if (list.size() == n) return Optional.empty();
        int next = list.get(n++) / size;

        Deque<Integer> backup = new ArrayDeque<>();

        while (!stack.isEmpty()) {
            if (next == stack.peek()) break;
            else backup.push(stack.pop());
        }

        if (stack.isEmpty()) clash += 1;
        else stack.pop();

        if (backup.size() == len) backup.pop();
        while (!backup.isEmpty()) stack.push(backup.pop());
        stack.push(next);

        return Optional.ofNullable(stackToList());
    }

    /**
     * 将地址栈转换为页表
     */
    public List<Integer> stackToList() {
        return new ArrayList<>(stack);
    }
}
