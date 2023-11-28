package egov.lab.lab01.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Domain extends BaseEntity{
    @OneToMany(mappedBy = "domain", cascade = CascadeType.ALL)
    private List<Course> courses;
}
