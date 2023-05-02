package programming2.unit3.TapeForTuringMachine;

/**
 * Represents one cell on a Turing Machine tape.
 */
public class MyCell {

	public char content; // The character in this cell.
	public MyCell next; // Pointer to the cell to the right of this one.
	public MyCell prev; // Pointer to the cell to the left of this one.

}
