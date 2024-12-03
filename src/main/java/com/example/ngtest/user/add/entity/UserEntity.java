package com.example.ngtest.user.add.entity;

import com.example.ngtest.user.add.enums.AuthenticationType;
import com.example.ngtest.user.add.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    private String firstName;
    private String lastName;
    private String distinguishingName;

    @Column(nullable = false)
    private String email;

    private String password;
//    private UUID commonUserId;

//    @JsonIgnore
//    @Column(name = "password", columnDefinition = "TEXT")
//    private String password;

//    @NotNull(message = "{bean.validation.create-user.authentication-type.required}")
    @Enumerated(EnumType.STRING)
    private AuthenticationType authenticationType;

//    @Column(name = "lock_user")
//    @Builder.Default
//    private Boolean lock = Boolean.FALSE;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private String securityQues1;
//    private String securityAns1;
//    private String securityQues2;
//    private String securityAns2;
//    private String businessJustification;
//
//    @Column(name = "profile")
//    @JdbcTypeCode(SqlTypes.LONGVARBINARY)
//    @Lob
//    private byte[] profile;

//    @Builder.Default
//    @JsonBackReference
//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(
//            name = "user_group_mapping",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "group_id"))
//    private Set<GroupEntity> groupEntities = Sets.newHashSet();

//    @Builder.Default private boolean sPhraseResetRequested = false;

    @Override
    public int hashCode() {
        return java.util.Objects.hashCode(id);
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
