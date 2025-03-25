package src.model.categories;

import jakarta.persistence.*;
import src.model.user.User;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue
    private Long cId;

    @ManyToOne
    @JoinColumn(name = "U_ID")
    private User user;

    @Enumerated(EnumType.STRING)
    private CategoryEnum.Category name;

    public Category() {

    }

    public Category(User user, CategoryEnum.Category name) {
        this.user = user;
        this.name = name;
    }

    public Long getCategoryId() {
        return this.cId;
    }

    public void setCategoryId(Long categoryId) {
        this.cId = categoryId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
