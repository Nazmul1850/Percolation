/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackOfStrings {
    private class Node {
        String item;
        Node next;
    }

    private Node first = null;

    public boolean isEmpty() {
        return first == null;
    }


    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }


    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] args) {
        int x = StdIn.readInt();
        StdOut.println(x);
    }
}

