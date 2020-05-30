package br.com.polls.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.polls.model.Choice;

public interface ChoiceService {

	Page<Choice> buscarPorFuncionarioId(Long choiceId, PageRequest pageRequest);
	
	Optional<Choice> buscarPorId(Long id);
	
	Choice persistir(Choice choice);
	
	void remover(Long id);
}
