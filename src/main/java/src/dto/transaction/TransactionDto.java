package src.dto.transaction;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import src.dto.categories.CategoryDto;
import src.dto.user.UserDto;
import src.model.transactions.TransactionsEnum;

import java.util.Date;

public class TransactionDto {

    private Long id;

    @NotNull(message = "User is required")
    private UserDto user;
    @NotNull(message = "Category is required")
    private CategoryDto category;

    @Positive
    private Double amount;

    @NotNull(message = "Type is required")
    private TransactionsEnum.Transaction type;

    private String comment;

    @NotNull(message = "Date is required")
    private Date date;

    public TransactionDto() {}

    public TransactionDto(Long id, UserDto user, CategoryDto category, Double amount, TransactionsEnum.Transaction type, Date date) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.comment = "";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return this.user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public CategoryDto getCategory() {
        return this.category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionsEnum.Transaction getType() {
        return this.type;
    }

    public void setType(TransactionsEnum.Transaction type) {
        this.type = type;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
