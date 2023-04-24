package programming2.unit3.TapeForTuringMachine;

/**
 * A Turing machine works on a "tape" that is used for both input and output.
 * The tape is made up of little squares called cells lined up in a horizontal
 * row that stretches, conceptually, off to infinity in both directions. Each
 * cell can hold one character. Initially, the content of a cell is a blank
 * space. One cell on the tape is considered to be the current cell. This is the
 * cell where the machine is located. As a Turing machine computes, it moves
 * back and forth along the tape and the current cell changes.
 *
 * A Turing machine tape can be represented by a doubly-linked list where each
 * cell has a pointer to the previous cell (to its left) and to the next cell
 * (to its right). The pointers will allow the machine to advance from one cell
 * to the next cell on the left or to the next cell on the right.
 */
public class Tape {
    // An instance variable of type Cell that points to the current cell
    private Cell currentCell;

    /**
     * Creates a tape that initially consists of a single cell.
     * The cell should contain a blank space, and the current cell pointer should
     * point to it.
     */
    public Tape() {
        Cell cell = new Cell();
        cell.content = ' ';
        currentCell = cell;
    }

    /**
     * Returns the pointer that points to the current cell.
     */
    public Cell getCurrentCell() {
        return currentCell;
    }

    /**
     * Returns the char from the current cell
     */
    public char getContent() {
        return currentCell.content;
    }

    /**
     * Changes the char in the current cell to the specified value.
     */
    public void setContent(char ch) {
        currentCell.content = ch;
    }

    /**
     * Moves the current cell one position to the left along the tape. Note that if
     * the current cell is the leftmost cell that exists, then a new cell must be
     * created and added to the tape at the left of the current cell, and then the
     * current cell pointer can be moved to point to the new cell. The content of
     * the new cell should be a blank space. (Remember that the Turing machine's
     * tape is conceptually infinite, so your linked list must be prepared to expand
     * on-demand when the machine wants to move past the current end of the list.)
     */
    public void moveLeft() {
        if (currentCell.prev == null) {
            Cell cell = new Cell();
            cell.content = ' ';
            cell.next = currentCell;
            currentCell.prev = cell;
        }
        currentCell = currentCell.prev;
    }

    /**
     * Moves the current cell one position to the right along the tape. Note that if
     * the current cell is the rightmost cell that exists, then a new cell must be
     * created and added to the tape at the right of the current cell, and then the
     * current cell pointer can be moved to point to the new cell. The content of
     * the new cell should be a blank space.
     */
    public void moveRight() {
        if (currentCell.next == null) {
            Cell cell = new Cell();
            cell.content = ' ';
            cell.prev = currentCell;
            currentCell.next = cell;
        }
        currentCell = currentCell.next;
    }

    /**
     * Returns a String consisting of the chars from all the cells on the tape, read
     * from left to right, except that leading or trailing blank characters should
     * be discarded. The current cell pointer should not be moved by this method; it
     * should point to the same cell after the method is called as it did before.
     * You can create a different pointer to move along the tape and get the full
     * contents. (This method is the hardest one to implement.)
     */
    public String getTapeContents() {
        Cell leftmost = currentCell;
        // Loop over until reaching to the leftmost.
        while (leftmost.prev != null) {
            leftmost = leftmost.prev;
        }

        // Build the contents string
        StringBuilder sb = new StringBuilder();
        Cell current = leftmost;
        // There is a Cell without the content.
        while (current != null && current.content == ' ') {
            current = current.next;
        }
        // There is a Cell with content.
        while (current != null) {
            sb.append(current.content);
            current = current.next;
        }
        // If the string has a character at least and the last character is blank space,
        // delete the blank space.
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}
