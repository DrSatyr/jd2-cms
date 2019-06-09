package by.itacademy.pinchuk.jd2.database.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@DiscriminatorValue("ADMINISTRATOR")
public class Administrator extends Editor {

    @Builder(builderMethodName = "administratorBuilder")
    public Administrator(Long id, String username, String email, String phone, String password, Boolean active,
                         UserRole role, LocalDateTime registerDate, LocalDateTime birthDate, String name,
                         String surname, Set<Comment> comments, String additionalInfo, Set<Content> contents) {
        super(id, username, email, phone, password, active, role, registerDate, birthDate, name, surname,
                comments, additionalInfo, contents);
    }
}
