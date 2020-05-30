package br.com.polls.repository;

import java.util.Optional;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import br.com.polls.model.Choice;


@Transactional(readOnly = true)
@NamedQueries({
		@NamedQuery(name = "ChoiceRepository.findChoiceById", 
				query = "SELECT ch FROM Choice ch WHERE ch.poll.id = :choiceId") })
@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {
	
	Page<Choice> findByPollId(@Param("pollId") Long pollId, Pageable pageable);

    Optional<Choice> findByPollId(@Param("pollId") Long pollId);

}
