package mywork20140106;

public class Cell {

    private String value;
    private boolean isAvailable;

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Cell() {

    }

    public Cell(String value) {
        this.value = value;
        this.isAvailable = true;
    }
}
