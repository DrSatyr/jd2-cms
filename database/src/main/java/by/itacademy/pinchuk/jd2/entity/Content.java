package by.itacademy.pinchuk.jd2.entity;

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@ToString(exclude = {"comments", "tags", "translations"})
@EqualsAndHashCode(exclude = {"comments", "tags", "translations"})
@Entity
@Table(name = "content", schema = "app")
public class Content implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "content_type_id")
    private ContentType contentType;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "alias")
    private String alias;

    @Column(name = "created")
    private LocalDateTime created;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(name = "publish_up")
    private LocalDateTime publishUp;

    @Column(name = "publish_down")
    private LocalDateTime publishDown;

    @Column(name = "hits")
    private Integer hits;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "extra_fields")
    private String extraFields;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "content_tag", schema = "app",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Builder.Default
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy = "content", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "id.content", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<ContentTranslation> translations = new HashSet<>();

    public void addTag(Tag tag) {
        tag.getContents().add(this);
        tags.add(tag);
    }

    public void addComment(Comment comment) {
        comment.setContent(this);
        comments.add(comment);
    }

    public void addTranslation(ContentTranslation translation) {
        translation.getId().setContent(this);
        translations.add(translation);
    }

    /**
     * Convert row JSON from database to Map collection.
     *
     */
    // TODO: 2019-05-22 just get it work!
    public Map<String, String> getExtraFields() {
        return new HashMap<>();
    }
}
