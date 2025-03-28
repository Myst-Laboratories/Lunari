package src.repositories.categories;

import org.springframework.data.repository.CrudRepository;
import src.model.categories.Category;
import src.model.user.User;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category getBycId(Long id);
    Category getByNameAndUser(Category category, User user);
    List<Category> findAllByUser(User user);

}
