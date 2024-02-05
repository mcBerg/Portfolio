package org.berg.portfolio.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {

    @Override
    List<PersonEntity> findAll();

    @Override
    Optional<PersonEntity> findById(UUID id);
}
