package br.com.polls.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.polls.model.Choice;


@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {

    Optional<Choice> findById(Long choiceId);

}
