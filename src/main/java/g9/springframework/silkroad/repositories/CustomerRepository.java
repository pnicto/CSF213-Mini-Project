package g9.springframework.silkroad.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import g9.springframework.silkroad.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
