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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "content_translation", schema = "app")
public class ContentTranslation implements BaseEntity<ContentTranslation.ComplexId> {

    @EmbeddedId
    private ContentTranslation.ComplexId id;

    @Column(name = "title")
    private String title;

    @Column(name = "intro_text")
    private String introText;

    @Column(name = "full_text")
    private String fullText;

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
        @JoinColumn(name = "content_id")
        private Content content;

        @Column(name = "lang")
        @Enumerated(EnumType.STRING)
        private Lang lang;

        public ComplexId(Lang lang) {
            this.lang = lang;
        }
    }
}
