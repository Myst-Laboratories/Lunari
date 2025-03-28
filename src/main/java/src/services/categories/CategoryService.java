package src.services.categories;

import src.dto.categories.CategoryDto;
import src.dto.user.UserDto;
import src.model.categories.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll(UserDto userDto);
    public Category findByName(CategoryDto category, UserDto user);
}
