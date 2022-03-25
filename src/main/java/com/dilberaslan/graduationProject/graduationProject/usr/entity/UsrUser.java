package com.dilberaslan.graduationProject.graduationProject.usr.entity;

import com.dilberaslan.graduationProject.graduationProject.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Dilber
 */
@Entity
@Table(name = "USR_USER")
@Data
public class UsrUser extends BaseEntity {
    @Id
    @SequenceGenerator(name = "UsrUser", sequenceName = "USR_USER_ID_SEQ")
    @GeneratedValue(generator = "UsrUser")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @Column(name = "USER_NAME", length = 100, nullable = false, unique = true)
    private String userName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;
}
