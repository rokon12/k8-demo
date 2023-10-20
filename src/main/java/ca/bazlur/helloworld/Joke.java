package ca.bazlur.helloworld;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Joke {
    @Id
    private Long id;

    private String jokeContent;

}
