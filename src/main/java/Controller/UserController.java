package Controller;

import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLOutput;


@Controller
public class UserController {

    /**
     * 自动装配userService 也可以放在setUserService方法上实现自动装配
     */
    @Autowired
    private UserService userService;

    public void execute() {
        System.out.println("UserController execute....");
        userService.add();
    }
}
