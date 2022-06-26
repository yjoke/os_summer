package top.xin1901.os.process;

/**
 * @author HeYunjia
 */
public class Consumer {

    /**
     * 消费第一个产品
     * @param storage
     * @throws InterruptedException
     */
    public static void consumption(Storage storage, long time) {

        try {
            while (storage.isEmpty());
            while (storage.take());

            Product remove = storage.getProducts().remove(0);
            System.out.println("使用产品: " + remove + "; 容器当前容量: " + storage.getProducts().size());

            storage.free();

            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
