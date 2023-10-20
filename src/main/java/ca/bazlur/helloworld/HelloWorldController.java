package ca.bazlur.helloworld;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
public class HelloWorldController {
    private final JokeRepository jokeRepository;

    @GetMapping("/hello")
    public @ResponseBody Joke hello() {
        return jokeRepository.getRandomJoke();
    }
}
