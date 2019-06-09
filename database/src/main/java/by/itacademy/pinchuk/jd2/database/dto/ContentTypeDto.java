package by.itacademy.pinchuk.jd2.database.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentTypeDto implements BaseDto<Long> {

    private Long id;
    private String name;
    private Boolean active;
}
