package org.berg.portfolio.person;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;

import java.util.UUID;

@Entity(name = "Person")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String name;
}
