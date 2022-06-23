package hexlet.code.domain;

public final class QuestionAnswerPair {
    private final String question;
    private final String answer;

    public QuestionAnswerPair(String value1, String value2) {
        this.question = value1;
        this.answer = value2;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
