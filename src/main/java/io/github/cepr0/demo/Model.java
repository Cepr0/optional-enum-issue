package io.github.cepr0.demo;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import static javax.persistence.EnumType.STRING;

@Data
@Entity
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
public class Model {
	@Id
	private Integer id;

	private String name;

	@Enumerated(STRING)
	@Type(type = "pgsql_enum")
	private ModelType type;

	@Enumerated(STRING)
	private ModelStatus status;
}
