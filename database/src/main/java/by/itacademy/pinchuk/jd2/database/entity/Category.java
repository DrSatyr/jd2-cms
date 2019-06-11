package by.itacademy.pinchuk.jd2.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"translations", "parentCategory", "contents"})
@ToString(exclude = {"translations", "parentCategory", "contents"})
@Entity
@Table(name = "category", schema = "app")
public class Category implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    @Builder.Default
    private Set<Category> childCategories = new HashSet<>();

    @Column(name = "alias")
    private String alias;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "category")
    @Builder.Default
    private Set<Content> contents = new HashSet<>();

    @OneToMany(mappedBy = "id.category", orphanRemoval = true, cascade = CascadeType.ALL)
    @MapKey(name = "id.lang")
    @Builder.Default
    private Map<Lang, CategoryTranslation> translations = new HashMap<>();

    public void addTranslation(CategoryTranslation translation) {
        translation.getId().setCategory(this);
        translations.put(translation.getId().getLang(), translation);
    }

    public void addContent(Content content) {
        content.setCategory(this);
        contents.add(content);
    }

    public void addChildCategory(Category category) {
        category.setParentCategory(this);
        childCategories.add(category);
    }

    public void removeChildCategory(Category category) {
        childCategories.remove(category);
    }
}
