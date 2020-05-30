package br.com.polls.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.polls.model.Choice;
import br.com.polls.service.ChoiceService;

public class ChoiceServiceImpl implements ChoiceService {

	@Override
	public Page<Choice> searchByChoiceId(Long choiceId, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
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
