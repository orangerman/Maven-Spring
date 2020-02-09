package repository;


import annotation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository("userRepository")
@Repository
public class UserRepositoryImpl implements UserRepository {

    private TestObject testObject;

    /**
     * @Autowired(required = false) IOC容器中没有该bean也会执行
     * @param testObject
     */
    @Autowired(required = false)
    public void setTestObject(TestObject testObject) {
        this.testObject = testObject;
    }

    public void save() {
        System.out.println("UserRepository Save...");
        System.out.println(testObject);

    }
}
