package tx;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

    private ApplicationContext ctx;
    private BookShopDao bookShopDao;
    private BookShopService bookShopService;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
    }

    @Test
    public void testBookShopDaoFindPriceByIsbn() {
        System.out.println(bookShopDao.findBookPriceByuIsbn("1001"));

    }
    @Test
    public void testUpdateBookStock() {
        bookShopDao.updateBookStock("1001");

    }
    @Test
    public void testBookShopDaoUpdateUserAccount() {
        bookShopDao.updateUserAccount("AA", 200);

    }



    @Test
    public void testBookshopService() {
        bookShopService.purchase("AA", "1001");
    }


}
