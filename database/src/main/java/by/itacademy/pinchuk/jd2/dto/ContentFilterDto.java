package by.itacademy.pinchuk.jd2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentFilterDto {

    private LimitFilterDto paging;
    private Boolean active;
    private String title;
    private String createdBy;
    private String tag;
}
