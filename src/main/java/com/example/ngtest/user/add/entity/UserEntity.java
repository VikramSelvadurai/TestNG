package com.example.ngtest.user.add.entity;

import com.example.ngtest.user.add.enums.AuthenticationType;
import com.example.ngtest.user.add.enums.UserStatus;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    private String firstName;
    private String lastName;
    private String distinguishingName;

    @Column(nullable = false)
    private String email;

    private String password;
    @Enumerated(EnumType.STRING)
    private AuthenticationType authenticationType;


    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private String securityQues1;


    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        UserEntity usersEntity = (UserEntity) o;
        return usersEntity.id.equals(this.id);
    }

}
