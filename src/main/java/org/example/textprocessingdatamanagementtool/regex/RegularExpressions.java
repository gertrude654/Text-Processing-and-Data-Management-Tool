package org.example.textprocessingdatamanagementtool.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

    //method for search pattern
    public boolean searchPatternInText(String text, String pattern) {
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(text);
        return matcher.find();
    }

    //method for match pattern
    public boolean matchPatternInText(String text, String pattern) {
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(text);
        return matcher.matches();
    }

    //method for replace pattern
    public String replacePatternInText(String text, String pattern, String replacement) {
        return text.replaceAll(pattern, replacement);
    }
}