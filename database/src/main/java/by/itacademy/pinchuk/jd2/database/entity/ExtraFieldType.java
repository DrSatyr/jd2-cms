package by.itacademy.pinchuk.jd2.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "extraFields")
@ToString(exclude = "extraFields")
@Entity
@Table(name = "extra_field_type")
public class ExtraFieldType implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "metadata")
    private String metadata;

    @OneToMany(mappedBy = "extraFieldType")
    @Builder.Default
    private List<ExtraField> extraFields = new ArrayList<>();

    public void addExtraField(ExtraField extraField) {
        extraField.setExtraFieldType(this);
        extraFields.add(extraField);
    }
}
