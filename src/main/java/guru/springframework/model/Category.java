package guru.springframework.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    /**
     * Use GenerationType of identity to support automated sequence generation. Maybe not supported in Oracle*
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mapped using categories on recipe
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
    private String categoryDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
