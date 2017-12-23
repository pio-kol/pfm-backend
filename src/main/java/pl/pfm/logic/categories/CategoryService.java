package pl.pfm.logic.categories;

import org.springframework.stereotype.Service;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getOneCategory(long id) {
        return categoryRepository.findOne(id);
    }

    public long postCategory(CategoryBody categoryBody) {
        Category createdCategory = Category.builder()
                .name(categoryBody.getCategoryName())
                .parentCategory(categoryBody.getParentCategory() != null ? categoryRepository.findOne(categoryBody.getParentCategory().getId()) : null)
                .build();
        categoryRepository.save(createdCategory);
        return createdCategory.getId();
    }

    public boolean deleteCategory(long id) {
        categoryRepository.delete(id);
        return categoryRepository.findOne(id) == null;
    }

    public Category putCategory(long id, CategoryBody categoryBody) {
        Category categoryToUpdate = categoryRepository.findOne(id);

        categoryToUpdate.setName(categoryBody.getCategoryName());
        categoryToUpdate.setParentCategory(categoryBody.getParentCategory() != null ? categoryRepository.findOne(categoryBody.getParentCategory().getId()) : null);

        categoryRepository.save(categoryToUpdate);

        return categoryToUpdate;
    }
}
