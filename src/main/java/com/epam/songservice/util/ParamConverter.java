package com.epam.songservice.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ParamConverter implements Converter<String, List<String>> {
    @Override
    public List<String> convert(String source) {
        return Arrays.asList(source.split(","));
    }
}
