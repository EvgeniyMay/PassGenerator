package com.learning.passGenerator.service;

import com.learning.passGenerator.dto.PasswordConfigDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@PropertySource("classpath:password.properties")
public class PasswordService {

    private final Random random = new Random();

    @Value("${password.tokens.characters.lowercase}")
    private String LOWER_CHARS;

    @Value("${password.tokens.characters.uppercase}")
    private String UPPER_CHARS;

    @Value("${password.tokens.numerals}")
    private String NUMERALS;

    @Value("${password.tokens.symbols}")
    private String SYMBOLS;


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

    public boolean isConfigValid(PasswordConfigDTO passConfig) {
        return getConfigErrors(passConfig).size() == 0;
    }

    public List<String> getConfigErrors(PasswordConfigDTO passConfig) {
        List<String> errors = new ArrayList<>();

        if(!passConfig.hasLowerChars()
                && !passConfig.hasUpperChars()
                && !passConfig.hasSymbols()
                && !passConfig.hasNumerals()) {
            errors.add("Choose at least one character type");
        }

        if(passConfig.getLength() < 1
                || passConfig.getLength() > 35) {
            errors.add("Length should be between 1 and 35");
        }

        return errors;
    }
}
