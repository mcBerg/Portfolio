package org.berg.portfolio.client;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class PersonDTO {
    UUID id;
    String name;

}
