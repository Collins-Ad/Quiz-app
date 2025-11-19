public class Question {
    private final String text;
    private final boolean answerTrue;
    private final String hint;
    private final int imageRes;

    public Question(String text, boolean answerTrue, String hint, int imageRes) {
        this.text = text;
        this.answerTrue = answerTrue;
        this.hint = hint;
        this.imageRes = imageRes;
    }

    public String getText() { return text; }
    public boolean isAnswerTrue() { return answerTrue; }
    public String getHint() { return hint; }
    public int getImageRes() { return imageRes; }
}

