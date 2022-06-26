package top.xin1901.os.process;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author HeYunjia
 */

@Data
@ToString
public class Storage {
    private List<Product> products;

    private boolean mutex;
    private int capacity;

    private Storage() {}

    public static Storage getStorage(int capacity) {
        Storage storage = new Storage();

        storage.setCapacity(capacity);
        storage.setMutex(false);

        return storage;
    }

    public boolean take() {
        if (mutex) return false;
        mutex = true;
        return true;
    }

    public void free() {
        mutex = false;
    }

    public boolean isFull() {
        return products.size() == capacity;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }
}
