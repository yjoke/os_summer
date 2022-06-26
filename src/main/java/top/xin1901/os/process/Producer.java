package top.xin1901.os.process;

import java.util.List;

/**
 * @author HeYunjia
 */
public class Producer {

    /**
     * 生产一个编号为 i, 名字为 "产品" 的产品 producer, 并存放在 producers 中
     * @param i 要生产的产品编号
     * @param products 要保存产品的容器
     * @return 添加是否成功
     */
    public static boolean production(int i, List<Product> products) {
        return production(new Product(i, "产品"), products);
    }

    /**
     * 生产一个编号为 i, 名字为 str 的产品 producer, 并存放在 producers 中
     * @param i 要生产的产品编号
     * @param str 要生产的产品名字
     * @param products 要保存产品的容器
     * @return 添加是否成功
     */
    public static boolean production(int i, String str, List<Product> products) {
        return production(new Product(i, str), products);
    }

    /**
     * 生产一个产品 producer, 并存放在 producers 中
     * @param product 要生产的产品属性
     * @param products 要保存产品的容器
     * @return 添加是否成功
     */
    public static boolean production(Product product, List<Product> products) {
        return products.add(product);
    }
}
