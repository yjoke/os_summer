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
    public static void consumption(Storage storage) throws InterruptedException {

        while (storage.isEmpty()) Thread.sleep(1000);
        while (storage.take()) Thread.sleep(1000);

        Product remove = storage.getProducts().remove(0);
        System.out.println("使用产品: " + remove);

        storage.free();
    }
}
