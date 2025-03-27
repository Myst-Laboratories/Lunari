package src.model.transactions;

import jakarta.persistence.*;
import src.model.categories.Category;
import src.model.user.User;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue
    public Long tId;

    @ManyToOne
    @JoinColumn(name = "U_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="C_ID")
    private Category category;

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    private TransactionsEnum.Transaction type;

    @Column(nullable = true)
    private String comment;

    @Column(nullable = false)
    private Date date;

    public Transaction() {}

    public Transaction(User user, Category category, Double amount, TransactionsEnum.Transaction type) {
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.type = type;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
