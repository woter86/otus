package ru.balovin.spring.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

import java.util.List;

@JsonPropertyOrder({"text", "ans", "correct"})
public class Question {
    private final String text;
    private final List<String> ans;
    private final int correct;

    public Question(@JsonProperty("text") String name, @JsonProperty("ans") List<String> ans,@JsonProperty("correct") int correct) {
        this.text = name;
        this.ans = ans;
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public List<String> getAns() {
        return ans;
    }

    public int getCorrect() {
        return correct;
    }
}
