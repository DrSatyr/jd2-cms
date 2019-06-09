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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@EqualsAndHashCode(exclude = {"contents", "extraFields"})
@ToString(exclude = {"contents", "extraFields"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "content_type", schema = "app")
public class ContentType implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "contentType")
    @Builder.Default
    private Set<Content> contents = new HashSet<>();

    @OneToMany(mappedBy = "contentType", cascade = {CascadeType.REMOVE})
    @Builder.Default
    private Set<ExtraField> extraFields = new HashSet<>();

    public void addContent(Content content) {
        content.setContentType(this);
        contents.add(content);
    }

    public void addExtraField(ExtraField extraField) {
        extraField.setContentType(this);
        extraFields.add(extraField);
    }
}
