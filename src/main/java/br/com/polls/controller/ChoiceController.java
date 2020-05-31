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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.polls.model.Choice;
import br.com.polls.payload.ChoiceDto;
import br.com.polls.service.ChoiceService;
import br.com.polls.util.AppConstants;
import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/choice")
@Api(value="choice API", description="api de respostas.")
public class ChoiceController {

    @Autowired
    private ChoiceService choiceService;
   

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
    
    private ChoiceDto parseChoiceDto(Choice choice) {
    	ChoiceDto c = new ChoiceDto();
		c.setId(Optional.of(choice.getId()));
		c.setText(choice.getText());
		c.setPollId(choice.getPoll().getId());
		return c;
	}

}
