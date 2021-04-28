package model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.repository.DictionaryRepository;
import model.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    DictionaryRepository dictionaryRepository;

    @Override
    public String findWord(String inputWord) {
        return dictionaryRepository.findWord(inputWord);
    }
}
