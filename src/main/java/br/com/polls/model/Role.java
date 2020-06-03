package br.com.polls.model;

import org.hibernate.annotations.NaturalId;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter 
@Setter
@Table(name = "roles")
public class Role {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;

	public Role() {
		// TODO Auto-generated constructor stub
	}

    public Role(RoleName name) {
        this.name = name;
    }

}