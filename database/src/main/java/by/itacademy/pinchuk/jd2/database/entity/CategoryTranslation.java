package by.itacademy.pinchuk.jd2.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category_translation", schema = "app")
public class CategoryTranslation implements BaseEntity<CategoryTranslation.ComplexId> {

    @EmbeddedId
    private ComplexId id;

    @Column(name = "title")
    private String title;

    @Column(name = "intro_text")
    private String introText;

    @Column(name = "meta_title")
    private String metaTitle;

    @Column(name = "meta_description")
    private String metaDescription;

    @Column(name = "meta_keywords")
    private String metaKeywords;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class ComplexId implements Serializable {

        @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;

        @Column(name = "lang")
        @Enumerated(EnumType.STRING)
        private Lang lang;

        public ComplexId(Lang lang) {
            this.lang = lang;
        }
    }
}
