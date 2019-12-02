package pl.javaNotFoundException.jpaAuditing.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import pl.javaNotFoundException.jpaAuditing.auditConfig.AuditTableEntity;

import javax.persistence.Entity;

@Entity
@SQLDelete(sql = "UPDATE user SET is_deleted = true WHERE id = ? AND version = ?")
@Where(clause = "is_deleted = false")
@Getter @Setter
@NoArgsConstructor
public class User extends AuditTableEntity {

    private String name;
    private String surname;
    private String email;

}
