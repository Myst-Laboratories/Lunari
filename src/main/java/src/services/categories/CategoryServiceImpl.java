package src.services.categories;

import src.dto.user.UserDto;
import src.dto.categories.CategoryDto;
import src.model.categories.Category;
import src.repositories.categories.CategoryRepository;
import src.repositories.user.UserRepository;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepo, UserRepository userRepo) {
        this.categoryRepository = categoryRepo;
        this.userRepository = userRepo;
    }

    @Override
    public List<Category> findAll(UserDto userDto) {
        var user = this.userRepository.findUserByuName(userDto.getUName());
        return this.categoryRepository.findAllByUser(user);
    }

    @Override
    public Category findByName(CategoryDto categoryDto, UserDto userDto) {
        var user = this.userRepository.findUserByuName(userDto.getUName());
        var category = this.categoryRepository.getBycId(categoryDto.getId());
        return this.categoryRepository.getByNameAndUser(category, user);
    }
}
