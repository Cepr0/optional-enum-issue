Spring Data JPA repository method, that should return Optional&lt;Enum&gt;, instead return Optional&lt;String&gt;. 

Example:

```java
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

	@Query(value = "select m.status from model m where m.id = ?1", nativeQuery = true)
	Optional<ModelStatus> getOptionalModelStatusById_Native(Integer id);

	@Query("select m.status from Model m where m.id = ?1")
	Optional<ModelStatus> getOptionalModelStatusById_Jpa(Integer id);

```

Full tests see in `io.github.cepr0.demo.ModelRepoTest`.
