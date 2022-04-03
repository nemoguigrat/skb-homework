package at2.ivanov.nikita.events.repository;

import at2.ivanov.nikita.events.model.ProductType;
import at2.ivanov.nikita.events.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Set<User> findUsersBySubscribeTypesContaining(ProductType productType);
}
