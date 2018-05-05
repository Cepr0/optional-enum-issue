package io.github.cepr0.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ModelRepoTest {

	@Autowired private ModelRepo modelRepo;

	@Before
	public void setUp() throws Exception {
		modelRepo.save(new Model(1, "model1", ModelType.TYPE1));
	}

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

	@Test
	public void getModelTypeById_Native() {
		ModelType type = modelRepo.getModelTypeById_Native(1);
		assertThat(type).isNotNull();
		assertThat(type).isOfAnyClassIn(ModelType.class);
	}

	@Test
	public void getModelTypeById_Jpa() {
		ModelType type = modelRepo.getModelTypeById_Jpa(1);
		assertThat(type).isNotNull();
		assertThat(type).isOfAnyClassIn(ModelType.class);
	}
}