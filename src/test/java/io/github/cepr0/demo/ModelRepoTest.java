package io.github.cepr0.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class ModelRepoTest {

	@Autowired private ModelRepo modelRepo;

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

	@Test
	public void getOptionalModelStatusById_Native() {
		Optional<ModelStatus> statusOptional = modelRepo.getOptionalModelStatusById_Native(1);
		assertThat(statusOptional).isNotEmpty();
		assertThat(statusOptional.get()).isOfAnyClassIn(ModelStatus.class);
	}

	@Test
	public void getOptionalModelStatusById_Jpa() {
		Optional<ModelStatus> statusOptional = modelRepo.getOptionalModelStatusById_Jpa(1);
		assertThat(statusOptional).isNotEmpty();
		assertThat(statusOptional.get()).isOfAnyClassIn(ModelStatus.class);
	}

	@Test
	public void getModelStatusById_Native() {
		ModelStatus status = modelRepo.getModelStatusById_Native(1);
		assertThat(status).isNotNull();
		assertThat(status).isOfAnyClassIn(ModelStatus.class);
	}

	@Test
	public void getModelStatusById_Jpa() {
		ModelStatus status = modelRepo.getModelStatusById_Jpa(1);
		assertThat(status).isNotNull();
		assertThat(status).isOfAnyClassIn(ModelStatus.class);
	}
}