package sia11.finantel.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import sia11.finantel.models.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
}
