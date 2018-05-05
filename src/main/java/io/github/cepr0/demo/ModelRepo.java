package io.github.cepr0.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@SuppressWarnings("SpringDataRepositoryMethodReturnTypeInspection")
public interface ModelRepo extends JpaRepository<Model, Integer> {

	String NATIVE_QUERY_TYPE = "select m.type as type from model m where m.id = ?1";
	String JPQL_QUERY_TYPE = "select m.type as type from Model m where m.id = ?1";

	@Query(value = NATIVE_QUERY_TYPE, nativeQuery = true)
	Optional<ModelType> getOptionalModelTypeById_Native(Integer id);

	@Query(JPQL_QUERY_TYPE)
	Optional<ModelType> getOptionalModelTypeById_Jpa(Integer id);

	@Query(value = NATIVE_QUERY_TYPE, nativeQuery = true)
	Optional<WithTypeProjection> getOptionalWithTypeProjectionById_Native(Integer id);

	@Query(JPQL_QUERY_TYPE)
	Optional<WithTypeProjection> getOptionalWithTypeProjectionById_Jpa(Integer id);

	@Query(value = NATIVE_QUERY_TYPE, nativeQuery = true)
	ModelType getModelTypeById_Native(Integer id);

	@Query(JPQL_QUERY_TYPE)
	ModelType getModelTypeById_Jpa(Integer id);

	@Query(value = NATIVE_QUERY_TYPE, nativeQuery = true)
	WithTypeProjection getWithTypeProjectionById_Native(Integer id);

	@Query(JPQL_QUERY_TYPE)
	WithTypeProjection getWithTypeProjectionById_Jpa(Integer id);

}
