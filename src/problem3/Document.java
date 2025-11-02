package problem3;

public abstract class Document {
    private static int counter = 1;
    private int numRec;
    private String title;

    public Document(String title) {
        this.numRec = counter++;
        this.title = title;
    }

    public int getNumRec() {
        return numRec;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Document #" + numRec + " - Title: " + title;
    }
}
