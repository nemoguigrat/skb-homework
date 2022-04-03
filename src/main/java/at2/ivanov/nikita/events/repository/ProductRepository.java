package at2.ivanov.nikita.events.repository;

import at2.ivanov.nikita.events.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
