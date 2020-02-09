package Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class UserService {


    private UserRepository userRepository;

    /**
     * 有了两个实现该接口的bean
     * ①申明bean时候//@Repository("userRepository")
     * ②装配时候  @Autowired
     *           @Qualifier("userRepositoryImpl")
     *           指定名字进行装配
     * @param userRepository
     */
    @Autowired
    @Qualifier("userRepositoryImpl")
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add() {
        System.out.println("UserService add....");
        userRepository.save();


    }
}
