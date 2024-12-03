package com.example.evaluateCredit_service.Entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String rut;
    private String email;
    private String name;
    private String password;
    //1 ==  User, 2 = Executive
    private Integer role;
    @Temporal(TemporalType.DATE)
    private Date birthdate;
}
