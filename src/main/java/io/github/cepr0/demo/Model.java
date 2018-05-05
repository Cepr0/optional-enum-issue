package io.github.cepr0.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import static javax.persistence.EnumType.STRING;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Model {

	@Id
	private Integer id;

	private String name;

	@Enumerated(STRING)
	@Column(length = 8, nullable = false)
	private ModelType type;
}
