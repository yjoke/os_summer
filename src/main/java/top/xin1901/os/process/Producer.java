package top.xin1901.os.process;

/**
 * @author HeYunjia
 */
public class Producer {

    /**
     * 生产一个产品, 添加至 storage 中
     * @param product
     * @param storage
     * @throws InterruptedException
     */
    public static void production(Product product, Storage storage) throws InterruptedException {

        while (storage.isFull()) Thread.sleep(1000);
        while (storage.take()) Thread.sleep(1000);

        storage.getProducts().add(product);
        System.out.println("生产产品: " + product);

        storage.free();
    }
}
