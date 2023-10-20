package ca.bazlur.helloworld;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JokeRepository extends JpaRepository<Joke, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM joke ORDER BY RANDOM() LIMIT 1")
    Joke getRandomJoke();
}
