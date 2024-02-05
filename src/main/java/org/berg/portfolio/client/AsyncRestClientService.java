package org.berg.portfolio.client;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import java.io.Serializable;
import java.util.List;

@Service
public class AsyncRestClientService implements Serializable {
    public static interface AsyncRestCallback<T> {
        void operationFinished(T results);
    }

    private static final String baseUrl = "http://localhost:8080/";
    private static final String getAllUrl = "person/all";
    private static final String addPersonUrl = "person/add";

    public void getAllPeopleAsync(AsyncRestCallback<List<PersonDTO>> callback) {
        RequestHeadersSpec<?> spec = WebClient.create().get().uri(baseUrl+getAllUrl);
        spec.retrieve().toEntityList(PersonDTO.class).subscribe(result -> {
            final List<PersonDTO> personList = result.getBody();
            System.out.printf("...received %d items.%n", personList.size());
            callback.operationFinished(personList);
        });
    }

    public PersonDTO addRando() {
        PersonDTO rando = PersonDTO.builder().name(RandomStringUtils.randomAlphabetic(8)).build();
        RequestHeadersSpec<?> spec = WebClient.create().put().uri(baseUrl+addPersonUrl).bodyValue(rando);
        return spec.retrieve().toEntity(PersonDTO.class).block().getBody();
    }
}
