Spring Data JPA repository method with native query, that should return **Optional&lt;Enum&gt;**, instead return **Optional&lt;String&gt;**. 

Spring Boot -  2.0.1

Spring Data JPA - 2.0.6

**Entity**

```java
@Entity
public class Model {
	
	@Id 
	private Integer id;
	
	private String name;
	
	@Enumerated(STRING) 
	@Column(length = 8, nullable = false) 
	private ModelType type;
}
```
**Repo methods**

```java

@Query(value = "select m.status from model m where m.id = ?1", nativeQuery = true)
Optional<ModelStatus> getOptionalModelStatusById_Native(Integer id);

@Query("select m.status from Model m where m.id = ?1")
Optional<ModelStatus> getOptionalModelStatusById_Jpa(Integer id);

```

**Tests**

```java
@Test
public void getOptionalModelTypeById_Native() {
    Optional<ModelType> typeOptional = modelRepo.getOptionalModelTypeById_Native(1);
    assertThat(typeOptional).isNotEmpty();
    assertThat(typeOptional.get()).isOfAnyClassIn(ModelType.class);
}

@Test
public void getOptionalModelTypeById_Jpa() {
    Optional<ModelType> typeOptional = modelRepo.getOptionalModelTypeById_Jpa(1);
    assertThat(typeOptional).isNotEmpty();
    assertThat(typeOptional.get()).isOfAnyClassIn(ModelType.class);
}
```

Full tests are in `io.github.cepr0.demo.ModelRepoTest`.
