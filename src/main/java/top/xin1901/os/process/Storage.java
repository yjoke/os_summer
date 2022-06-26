package top.xin1901.os.process;

import lombok.Data;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

/**
 * @author HeYunjia
 */

@Data
@ToString
public class Storage {
    /**
     * 存放产品的集合
     */
    private List<Product> products;

    /**
     * 当前是否被占用使用
     */
    private boolean mutex;

    /**
     * 集合容量
     */
    private int capacity;

    private Storage() {}

    /**
     * 创建一个容量为 capacity 的容器
     * @param capacity 容量
     * @return 返回改容器
     */
    public static Storage getStorage(int capacity) {
        Storage storage = new Storage();

        storage.setProducts(new LinkedList<>());
        storage.setCapacity(capacity);
        storage.setMutex(false);

        return storage;
    }

    /**
     * 占用该容器
     * @return 是否占用成功
     */
    public synchronized boolean take() {
        if (mutex) return true;
        mutex = true;
        return false;
    }

    /**
     * 释放占有权
     */
    public void free() {
        mutex = false;
    }

    /**
     * 判断容器是否满
     * @return 是否满
     */
    public boolean isFull() {
        return products.size() == capacity;
    }

    /**
     * 判断容器是否为空
     * @return 是否为空
     */
    public boolean isEmpty() {
        return products.isEmpty();
    }
}
