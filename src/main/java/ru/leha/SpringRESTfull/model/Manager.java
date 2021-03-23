package ru.leha.SpringRESTfull.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Simple JavaBean domain object that persistence Manager
 *
 * @author Aleksei Agishev
 * @version 1.0
 */
@Entity
@Table(name = "managers")
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Manager{
    @OneToMany(targetEntity=Client.class, mappedBy="manager_id", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Client> clients;

    @Id
    @SequenceGenerator(name = "managersIdSeq", sequenceName = "managers_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "managersIdSeq")
    private Long manager_id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
}