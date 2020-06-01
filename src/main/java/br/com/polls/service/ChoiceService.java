package br.com.polls.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import br.com.polls.model.Choice;

@Service
public interface ChoiceService {

	Page<Choice> searchByPollId(Long pollId, Pageable pageRequest);
	
	Optional<Choice> searchById(Long id);
	
	Choice persist(Choice choice);
	
	void remove(Long id);
}
