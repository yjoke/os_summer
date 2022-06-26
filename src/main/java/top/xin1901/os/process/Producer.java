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
    public static void production(Product product, Storage storage, long time) {

        try {
            while (storage.isFull());
            while (storage.take());

            storage.getProducts().add(product);
            System.out.println("生产产品: " + product + "; 容器当前容量: " + storage.getProducts().size());

            storage.free();

            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
