package ru.leha.SpringRESTfull.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Simple JavaBean domain object that persistence Client
 *
 * @author Aleksei Agishev
 * @version 1.0
 */

@Entity
@Table(name = "clients")
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client{

    //@ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="manager_id", insertable = false, updatable = false)
    //private Manager manager;

    @Id
    @SequenceGenerator(name = "clientsIdSeq", sequenceName = "clients_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientsIdSeq")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "manager_id")
    private Long manager_id;
}
