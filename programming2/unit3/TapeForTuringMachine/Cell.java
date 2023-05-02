package programming2.unit3.TapeForTuringMachine;

/**
 * Represents one cell on a Turing Machine tape.
 */
public class Cell {

    public char content; // The character in this cell.
    public Cell next; // Pointer to the cell to the right of this one.
    public Cell prev; // Pointer to the cell to the left of this one.

    public Cell() {
        content = ' ';
        next = null;
        prev = null;
    }

    public char getContent() {
        return content;
    }

    public void setContent(char content) {
        this.content = content;
    }

    public Cell getNext() {
        return next;
    }

    public void setNext(Cell next) {
        this.next = next;
    }

    public Cell getPrev() {
        return prev;
    }

    public void setPrev(Cell prev) {
        this.prev = prev;
    }

}