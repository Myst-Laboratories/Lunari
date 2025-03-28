package src.services.transactions;

import src.dto.categories.CategoryDto;
import src.dto.transaction.TransactionDto;
import src.dto.user.UserDto;
import src.model.transactions.Transaction;
import src.model.transactions.TransactionsEnum;

import java.util.List;

public interface TransactionService {
    public Transaction getTransactionById(Long id);
    public List<Transaction> getTransactionsByUser(UserDto userDto);
    public List<Transaction> getTransactionsByType(TransactionsEnum.Transaction type, UserDto userDto);
    public List<Transaction> getTransactionsByCategory(CategoryDto category, UserDto userDto);

    public void save(TransactionDto transaction);
    public void delete(TransactionDto transaction);
    public void edit(Long id, TransactionDto transaction);

}
