package br.com.polls.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


import br.com.polls.model.Choice;
import br.com.polls.repository.ChoiceRepository;
import br.com.polls.service.ChoiceService;

@Service
public class ChoiceServiceImpl implements ChoiceService {

	private static final Logger log = LoggerFactory.getLogger(ChoiceServiceImpl.class);
	
	@Autowired
	private ChoiceRepository choiceRepository;
	
	@Override
	public Page<Choice> searchByPollId(Long pollId, Pageable pageRequest) {
		log.info("Searching for choices by ID {}", pollId);
		return this.choiceRepository.findByPollId(pollId, pageRequest);
	}

	@Override
	public Optional<Choice> searchById(Long id) {
		log.info("Searching choice by ID {}", id);
		return this.choiceRepository.findById(id);
	}

	@Override
	public Choice persist(Choice choice) {
		log.info("persist choice: {}", choice);
		return this.choiceRepository.save(choice);
	}

	@Override
	public void remove(Long id) {
		log.info("Removendo o lançamento ID {}", id);
		this.choiceRepository.deleteById(id);
	}



}
