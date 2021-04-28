package model.repository.impl;

import org.springframework.stereotype.Repository;
import model.repository.DictionaryRepository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository {
    private static Map<String, String> wordMap = new HashMap<>();

    static {

        wordMap.put("hello1","xin chao1");
        wordMap.put("hello2","xin chao2");
        wordMap.put("hello3","xin chao3");
        wordMap.put("hello4","xin chao4");
        wordMap.put("hello5","xin chao5");

    }

    @Override
    public String findWord(String inputWord) {
        return wordMap.get(inputWord);
    }
}
