package by.itacademy.pinchuk.jd2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@ToString(exclude = {"contents", "comments"})
@EqualsAndHashCode(exclude = {"contents", "comments"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "app")
public class User implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "register_date")
    private LocalDateTime registerDate;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToMany(mappedBy = "createdBy")
    @Builder.Default
    private Set<Content> contents = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @Builder.Default
    private Set<Comment> comments = new HashSet<>();

    public void addContent(Content content) {
        content.setCreatedBy(this);
        contents.add(content);
    }

    public void addComment(Comment comment) {
        comment.setUser(this);
        comments.add(comment);
    }
}

