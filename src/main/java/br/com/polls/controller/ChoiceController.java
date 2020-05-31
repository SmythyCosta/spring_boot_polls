package br.com.polls.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.polls.model.Choice;
import br.com.polls.model.Poll;
import br.com.polls.payload.ChoiceDto;
import br.com.polls.payload.Response;
import br.com.polls.service.ChoiceService;
import br.com.polls.service.PollService;
import br.com.polls.util.AppConstants;
import io.swagger.annotations.Api;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import java.text.ParseException;





@RestController
@RequestMapping("/api/choice")
@Api(value="choice API", description="api de respostas.")
public class ChoiceController {

    @Autowired
    private ChoiceService choiceService;
    
    @Autowired
    private PollService pullService;
   

    private static final Logger logger = LoggerFactory.getLogger(ChoiceController.class);
    
    
    /*
     * Operations Choice
     *  
     * */
    
    
    @GetMapping(value = "/poll/{pollId}")
	public ResponseEntity<Page<ChoiceDto>> listByPollId(
			@PathVariable("pollId") Long pollId,
			@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
    	
    	logger.info("Searching choices by Poll: {}, pag: {}", pollId, page);
		
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "text");		
		Page<Choice> choices = this.choiceService.searchByPollId(pollId, pageable);
		Page<ChoiceDto> choicesDto = choices.map(choice -> parseChoiceDto(choice));

		return ResponseEntity.ok(choicesDto);
	}
    
	@PutMapping(value = "/{id}")
	public ResponseEntity<Response<ChoiceDto>> update(@PathVariable("id") Long id,
			@Valid @RequestBody ChoiceDto choiceDto, BindingResult result) throws ParseException {
		
		logger.info("Update choices: {}", choiceDto.toString());
		
		Response<ChoiceDto> response = new Response<ChoiceDto>();
		checkPoll(choiceDto, result);
		choiceDto.setId(Optional.of(id));
		Choice choice = parseDtoForChoice(choiceDto, result);

		if (result.hasErrors()) {
			logger.error("validate Erro in choice: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		choice = choiceService.persist(choice);
		response.setData(this.parseChoiceDto(choice));
		return ResponseEntity.ok(response);
	}
    
    private ChoiceDto parseChoiceDto(Choice choice) {
    	ChoiceDto c = new ChoiceDto();
		c.setId(Optional.of(choice.getId()));
		c.setText(choice.getText());
		c.setPollId(choice.getPoll().getId());
		return c;
	}
    
    private void checkPoll(ChoiceDto choiceDto, BindingResult result) {
		if (choiceDto.getPollId() == null) {
			result.addError(new ObjectError("polls", "poll not found."));
			return;
		}

		logger.info("Validate poll id {}: ", choiceDto.getPollId());
		Optional<Poll> p = this.pullService.searchById(choiceDto.getPollId());
		if (!p.isPresent()) {
			result.addError(new ObjectError("polls", "poll not found."));
		}
	}
    
    private Choice parseDtoForChoice(ChoiceDto choiceDto, BindingResult result) throws ParseException {
    	Choice choice = new Choice();

		if (choiceDto.getId().isPresent()) {
			Optional<Choice> ch = this.choiceService.searchById(choiceDto.getId().get());
			if (ch.isPresent()) {
				choice = ch.get();
			} else {
				result.addError(new ObjectError("choice", "Choice not found."));
			}
		} else {
			choice.setPoll(new Poll());
			choice.getPoll().setId(choiceDto.getPollId());
		}
		
		choice.setText(choiceDto.getText());

		return choice;
	}


}
