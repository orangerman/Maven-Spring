package tx;

public interface BookShopDao {


    //根据书号获取书的单价
    public int findBookPriceByuIsbn(String isbn);

    //更新书的库存
    public void updateBookStock(String isbn);


    //更新用户的账户余额
    public void updateUserAccount(String username, int price);


}
