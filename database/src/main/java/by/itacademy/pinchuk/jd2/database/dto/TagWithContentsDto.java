package by.itacademy.pinchuk.jd2.database.dto;

import by.itacademy.pinchuk.jd2.database.entity.Lang;
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
public class TagWithContentsDto implements BaseDto<Long> {

    private Long id;
    private Lang lang;
    private String value;
    @Builder.Default
    private Set<ContentDto> contents = new HashSet<>();
}
