package br.com.polls.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.polls.service.ChoiceService;
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

}
