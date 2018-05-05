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

@Query(value = "select m.type from model m where m.id = ?1", nativeQuery = true)
Optional<ModelType> getOptionalModelTypeById_Native(Integer id);

@Query("select m.type from Model m where m.id = ?1")
Optional<ModelType> getOptionalModelTypeById_Jpa(Integer id);

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

Test result for `getOptionalModelTypeById_Native` method:
 
```
java.lang.AssertionError: 
Expecting:
 <"TYPE1">
to be of one these types:
 <[io.github.cepr0.demo.ModelType]>
but was:
 <java.lang.String>
```

Full tests are in `io.github.cepr0.demo.ModelRepoTest`.

The issue [DATAJPA-1338](https://jira.spring.io/browse/DATAJPA-1338) is posted.
