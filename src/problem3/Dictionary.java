package problem3;

public class Dictionary extends Document {
    private String language;

    public Dictionary(String title, String language) {
        super(title);
        this.language = language;
    }

    @Override
    public String toString() {
        return super.toString() + ", Language: " + language;
    }
}

