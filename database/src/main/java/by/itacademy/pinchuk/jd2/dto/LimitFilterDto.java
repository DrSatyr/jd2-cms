package by.itacademy.pinchuk.jd2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LimitFilterDto {

    private Integer limit;
    @Builder.Default
    private Integer page = 1;

    public Integer getOffset() {
        return Objects.isNull(page)
                ? 0
                : (page - 1) * limit;
    }
}
