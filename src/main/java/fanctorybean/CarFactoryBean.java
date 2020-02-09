package fanctorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 第三种获取配置bean方法 实现FactoryBean接口
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;

    }

    public Car getObject() throws Exception {
        return new Car("dazhong", 300000);
    }

    public Class<?> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return true;
    }

}
