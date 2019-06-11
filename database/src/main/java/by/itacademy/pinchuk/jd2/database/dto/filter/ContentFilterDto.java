package by.itacademy.pinchuk.jd2.database.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentFilterDto {

    private LimiterDto paging;
    private Boolean active;
    private String title;
    private String createdBy;
    private String tag;
}
