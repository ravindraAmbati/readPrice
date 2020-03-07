package in.bigbasket.readPrice.repo;

import in.bigbasket.readPrice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    List<Product> findByPrice(Double price);

    List<Product> findByPriceAndQuantity(Double price, String quantity);

    List<Product> findByProdId(String prodId);

    List<Product> findByProdIdIn(List<String> prodIds);
}
