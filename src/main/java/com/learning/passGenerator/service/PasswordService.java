package com.learning.passGenerator.service;

import com.learning.passGenerator.dto.PasswordConfigDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PasswordService {

    private final Random random = new Random();

    // ToDo | Replace
    private final String LOWER_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private final String UPPER_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String NUMERALS = "0123456789";
    private final String SYMBOLS = "!@#$%&*()_+-=[]|,./?><";

    public String generateByConfig(PasswordConfigDTO passConfig) {
        char[] password = new char[passConfig.getLength()];

        List<Character> ableChars = new ArrayList<>();

        if(passConfig.hasLowerChars())
            ableChars.addAll(LOWER_CHARS.chars()
                    .mapToObj(c -> (char)c)
                    .collect(Collectors.toList()));

        if(passConfig.hasUpperChars())
            ableChars.addAll(UPPER_CHARS.chars()
                    .mapToObj(c -> (char)c)
                    .collect(Collectors.toList()));

        if(passConfig.hasNumerals())
            ableChars.addAll(NUMERALS.chars()
                    .mapToObj(c -> (char)c)
                    .collect(Collectors.toList()));

        if(passConfig.hasSymbols())
            ableChars.addAll(SYMBOLS.chars()
                    .mapToObj(c -> (char)c)
                    .collect(Collectors.toList()));

        for(int i=0; i<password.length; ++i) {
            password[i] = ableChars.get(random.nextInt(ableChars.size()));
        }

        return new String(password);
    }
}
