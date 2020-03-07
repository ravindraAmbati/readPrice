package in.bigbasket.readPrice;

import in.bigbasket.readPrice.entity.Product;
import in.bigbasket.readPrice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ReadPriceApplication implements CommandLineRunner{

	@Autowired
	private ProductRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(ReadPriceApplication.class, args);
		ReadPriceApplication m = new ReadPriceApplication();
	}

	@Override
	public void run(String... args) throws Exception {
		Product p = new Product();
		p.setProdId("101");
		p.setName("test");
		p.setPrice(100.0);
		p.setQuantity("100 gms");

		System.out.println(repo.save(p));

		p = new Product();
		p.setProdId("101");
		p.setName("test1");
		p.setPrice(70.0);
		p.setQuantity("1 Kg");

		System.out.println(repo.save(p));

		p = new Product();
		p.setProdId("103");
		p.setName("test3");
		p.setPrice(100.0);
		p.setQuantity("100 gms");

		System.out.println(repo.save(p));

		System.out.println(repo.findAll());

		System.out.println(repo.count());

		System.out.println(repo.existsById(1L));

		System.out.println(repo.findById(2L));

		List<Long> ids = new ArrayList<Long>();
		ids.add(1L);
		ids.add(2L);
		ids.add(2L);

		System.out.println(repo.findAllById(ids));

		repo.delete(p);

		System.out.println(repo.count());

		Optional<Product> optionalProd = repo.findById(2L);

		if(optionalProd.isPresent()){
			Product updateProd = optionalProd.get();
			updateProd.setQuantity("250 gms");
			updateProd.setProdId("104");

			System.out.println(repo.save(updateProd));
		}

		System.out.println(repo.findByPrice(100.0));

		System.out.println(repo.findByPriceAndQuantity(100.0,"100 gms"));

		System.out.println(repo.findByProdId("104"));

		List<String> prodIds = new ArrayList<>();
		prodIds.add("101");
		prodIds.add("102");
		prodIds.add("103");
		prodIds.add("104");

		System.out.println(repo.findByProdIdIn(prodIds));

	}
}
