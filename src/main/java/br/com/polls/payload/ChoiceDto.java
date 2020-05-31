package br.com.polls.payload;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class ChoiceDto {

	private Optional<Long> id = Optional.empty();
	@ToString.Include
	@NotEmpty()
	private String text;
	private Long pollId;

}
