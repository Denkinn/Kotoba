package application.kotoba.controller;

import application.kotoba.entity.Dictionary;
import application.kotoba.repository.DictionaryRepository;
import application.kotoba.repository.WordRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    private final DictionaryRepository dictionaryRepository;
    private final WordRepository wordRepository;

    public MainController(DictionaryRepository dictionaryRepository, WordRepository wordRepository) {
        this.dictionaryRepository = dictionaryRepository;
        this.wordRepository = wordRepository;
    }

    @PostMapping("/dictionary")
    public ResponseEntity<Dictionary> postDictionary(@RequestBody Dictionary dictionary) {

        Dictionary postedDictionary = dictionaryRepository.save(dictionary);

        return new ResponseEntity<>(postedDictionary, HttpStatus.CREATED);
    }


}
