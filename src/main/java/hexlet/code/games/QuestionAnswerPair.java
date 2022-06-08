package hexlet.code.games;

public final class QuestionAnswerPair {
    private String question;
    private String answer;

    public QuestionAnswerPair() {
    }

    public QuestionAnswerPair(String value1, String value2) {
        this.question = value1;
        this.answer = value2;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String value) {
        this.question = value;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String value) {
        this.answer = value;
    }
}
