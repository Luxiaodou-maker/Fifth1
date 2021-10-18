import javabean.User;
import org.junit.*;
import Dao.impl.ProductDao;
import javabean.Product;
import java.util.List;
public class ProductDaoTest {
    ProductDao pdao=new ProductDao();
    @Test
    public void testCreateUser(){
       Product product1=new Product();
          product1.setName("平板电脑");
          product1.setPrice(1900);
          pdao.save(product1);

    }
}
