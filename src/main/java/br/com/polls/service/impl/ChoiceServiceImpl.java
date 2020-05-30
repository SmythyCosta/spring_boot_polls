package br.com.polls.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.polls.model.Choice;
import br.com.polls.repository.ChoiceRepository;
import br.com.polls.service.ChoiceService;

@Service
public class ChoiceServiceImpl implements ChoiceService {

	private static final Logger log = LoggerFactory.getLogger(ChoiceServiceImpl.class);
	
	@Autowired
	private ChoiceRepository choiceRepository;
	
	@Override
	public Page<Choice> searchByPollId(Long pollId, PageRequest pageRequest) {
		log.info("Searching for choices by ID {}", pollId);
		return this.choiceRepository.findByPollId(pollId, pageRequest);
	}

	@Override
	public Optional<Choice> searchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Choice persistir(Choice choice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		
	}



}
