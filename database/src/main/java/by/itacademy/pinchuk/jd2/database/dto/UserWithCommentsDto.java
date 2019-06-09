package by.itacademy.pinchuk.jd2.database.dto;

import by.itacademy.pinchuk.jd2.database.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserWithCommentsDto implements BaseDto<Long> {

    private Long id;
    private String username;
    private String email;
    private String phone;
    private String password;
    private Boolean active;
    private UserRole role;
    private String registerDate;
    private String birthDate;
    private String name;
    private String surname;
    @Builder.Default
    private Set<CommentDto> comments = new HashSet<>();
}
