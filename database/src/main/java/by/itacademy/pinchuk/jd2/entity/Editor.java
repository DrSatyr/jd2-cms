package by.itacademy.pinchuk.jd2.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString(exclude = "contents", callSuper = true)
@EqualsAndHashCode(exclude = "contents", callSuper = true)
@NoArgsConstructor
@Entity
@DiscriminatorValue("EDITOR")
public class Editor extends User {

    @Column(name = "additional_info")
    private String additionalInfo;

    @OneToMany(mappedBy = "createdBy")
    private Set<Content> contents = new HashSet<>();

    public void addContent(Content content) {
        content.setCreatedBy(this);
        contents.add(content);
    }


    @Builder(builderMethodName = "editorBuilder")
    public Editor(Long id,
                  String username,
                  String email,
                  String phone,
                  String password,
                  Boolean active,
                  UserRole role,
                  LocalDateTime registerDate,
                  LocalDateTime birthDate,
                  String name,
                  String surname,
                  Set<Comment> comments,
                  String additionalInfo,
                  Set<Content> contents) {
        super(id, username, email, phone, password, active, role, registerDate, birthDate, name, surname, comments);
        this.additionalInfo = additionalInfo;
        this.contents = contents;
    }

    /**
     * Simple builder class definition to initialize "Set<Content> contents" for lombok generated builder()
     * Builder.Default annotation is allowed only when class (not constructor) is annotated as Builder.
     */
    public static class EditorBuilder {
        private Set<Content> contents = new HashSet<>();
    }
}
