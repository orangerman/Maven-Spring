package tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {


    @Autowired
    private BookShopDao bookShopDao;

    @Override
    public void purchase(String username, String isbn) {

        int price = bookShopDao.findBookPriceByuIsbn(isbn);
        bookShopDao.updateBookStock(isbn);
        bookShopDao.updateUserAccount(username, price);
    }
}
