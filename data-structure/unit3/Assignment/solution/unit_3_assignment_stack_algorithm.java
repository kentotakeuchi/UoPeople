import Prog1Tools.IOTools;

class StackNode {
    StackNode ptr;
    int value;

    public StackNode(int value) {
        this.value = value;
    }
}

public class StackAlgorithm {

    public static void main(String[] args) {
        StackNode link;

        link = null;
        link = push(link, 0);
        System.out.println("Pushed on stack Value: " + link.value);

        link = push(link, 1);
        System.out.println("Pushed on stack Value: " + link.value);

        link = push(link, 2);
        System.out.println("Pushed on stack Value: " + link.value);

        System.out.println("Pop from Stack Value: " + link.value);
        link = pop(link);

        System.out.println("Pop from Stack Value: " + link.value);
        link = pop(link);

        System.out.println("Pop from Stack Value: " + link.value);
        link = pop(link);
    }

    public static StackNode push(StackNode node, int value) {
        StackNode nnode;

        if (node != null) {
            nnode = new StackNode(value);
            nnode.ptr = node;
        } else {
            nnode = new StackNode(value);
            nnode.ptr = null;
        }
        return (nnode);
    }

    public static StackNode pop(StackNode node) {

        if (node != null) {
            return (node.ptr);
        } else
            System.out.println("Nothing on the stack");
        return (null);
    }
}
