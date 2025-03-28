package src.repositories.transactions;

import org.springframework.data.repository.CrudRepository;
import src.model.categories.Category;
import src.model.transactions.Transaction;
import src.model.transactions.TransactionsEnum;
import src.model.user.User;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Transaction getBytId(Long id);
    List<Transaction> getByUser(User user);
    List<Transaction> getByTypeAndUser(TransactionsEnum.Transaction type, User user);
    List<Transaction> getByCategoryAndUser(Category category, User user);
}
