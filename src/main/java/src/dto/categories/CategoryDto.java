package src.dto.categories;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import src.dto.user.UserDto;
import src.model.categories.CategoryEnum;

public class CategoryDto {

    private Long id;

    @NotNull(message = "User is required")
    private UserDto user;
    @NotNull(message = "Category is required")
    private CategoryEnum.Category name;

    public CategoryDto(){}

    public CategoryDto(Long id, UserDto user, CategoryEnum.Category name) {
        this.id = id;
        this.user = user;
        this.name = name;
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

    public CategoryEnum.Category getName() {
        return this.name;
    }

    public void setName(CategoryEnum.Category name) {
        this.name = name;
    }
}
