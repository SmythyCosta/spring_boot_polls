package br.com.polls.repository;

import java.util.Optional;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import br.com.polls.model.Choice;


@Transactional(readOnly = true)
@NamedQueries({
		@NamedQuery(name = "ChoiceRepository.findChoiceById", 
				query = "SELECT ch FROM Choice ch WHERE ch.id = :choiceId") })
@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {

    Optional<Choice> findChoiceById(@Param("choiceId") Long choiceId);

}
