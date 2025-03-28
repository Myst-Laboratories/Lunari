package src.services.transactions;

import org.springframework.stereotype.Service;
import src.dto.categories.CategoryDto;
import src.dto.transaction.TransactionDto;
import src.dto.user.UserDto;
import src.model.transactions.Transaction;
import src.model.transactions.TransactionsEnum;
import src.repositories.categories.CategoryRepository;
import src.repositories.transactions.TransactionRepository;
import src.repositories.user.UserRepository;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, UserRepository userRepository, CategoryRepository catRepository) {
        super();
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.categoryRepository = catRepository;
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return this.transactionRepository.getBytId(id);
    }

    @Override
    public List<Transaction> getTransactionsByUser(UserDto userDto) {
        var user = this.userRepository.findUserByuName(userDto.getUName());
        return this.transactionRepository.getByUser(user);
    }

    @Override
    public List<Transaction> getTransactionsByType(TransactionsEnum.Transaction type, UserDto userDto) {
        var user = this.userRepository.findUserByuName(userDto.getUName());
        return this.transactionRepository.getByTypeAndUser(type, user);
    }

    @Override
    public List<Transaction> getTransactionsByCategory(CategoryDto categoryDto, UserDto userDto) {
        var user = this.userRepository.findUserByuName(userDto.getUName());
        var category = this.categoryRepository.getBycId(categoryDto.getId());
        return this.transactionRepository.getByCategoryAndUser(category, user);
    }

    @Override
    public void save(TransactionDto transaction) {
        var user = this.userRepository.findUserByuName(transaction.getUser().getUName());
        var category = this.categoryRepository.getBycId(transaction.getCategory().getId());
        var newTransaction = new Transaction(user, category, transaction.getAmount(), transaction.getType());
        this.transactionRepository.save(newTransaction);
    }

    @Override
    public void delete(TransactionDto transaction) {
        var transactionToRemove = this.transactionRepository.getBytId(transaction.getId());
        this.transactionRepository.delete(transactionToRemove);
    }

    @Override
    public void edit(Long id, TransactionDto transaction) {
        var oldTransaction = this.transactionRepository.getBytId(id);
        var user = this.userRepository.findUserByuName(transaction.getUser().getUName());
        var category = this.categoryRepository.getBycId(transaction.getCategory().getId());
        oldTransaction.setUser(user);
        oldTransaction.setCategory(category);
        oldTransaction.setAmount(transaction.getAmount());
        oldTransaction.setDate(transaction.getDate());
        this.transactionRepository.save(oldTransaction);
    }


}


























