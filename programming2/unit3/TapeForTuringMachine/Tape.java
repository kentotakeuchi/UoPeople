
package programming2.unit3.TapeForTuringMachine;

public class Tape {
    public Cell currentCell;

    public Tape() {
        this.currentCell = new Cell();
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public char getContent() {
        return currentCell.getContent();
    }

    public void setContent(char ch) {
        currentCell.setContent(ch);
    }

    public void moveLeft() {
        if (currentCell.getPrev() == null) {
            Cell newCell = new Cell();
            newCell.setNext(currentCell);
            currentCell.setPrev(newCell);
        }
        currentCell = currentCell.getPrev();
    }

    public void moveRight() {
        if (currentCell.getNext() == null) {
            Cell newCell = new Cell();
            newCell.setPrev(currentCell);
            currentCell.setNext(newCell);
        }
        currentCell = currentCell.getNext();
    }

    public String getTapeContents() {
        Cell tempCell = currentCell;
        while (tempCell.getPrev() != null) {
            tempCell = tempCell.getPrev();
        }
        String contents = "";
        String pendingSpaces = "";
        while (tempCell != null) {
            if (tempCell.getContent() != ' ') {
                contents += pendingSpaces + tempCell.getContent();
                pendingSpaces = "";
            } else {
                pendingSpaces += tempCell.getContent();
            }
            tempCell = tempCell.getNext();
        }
        return contents;
    }
}
