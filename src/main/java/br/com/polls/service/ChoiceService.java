package br.com.polls.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.polls.model.Choice;

public interface ChoiceService {

	Page<Choice> searchByChoiceId(Long choiceId, PageRequest pageRequest);
	
	Optional<Choice> searchById(Long id);
	
	Choice persistir(Choice choice);
	
	void remover(Long id);
}
