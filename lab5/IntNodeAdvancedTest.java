// Lab 5 - Jingru - Dou - IntNodeAdvancedTest.zip

public class IntNodeAdvancedTest {

    public static void main(String[] args) {
        //check cycle
        IntNode node3 = new IntNode(12, null);
        IntNode node4 = new IntNode(0, node3);
        IntNode node5 = new IntNode(28, node4);
        IntNode node6 = new IntNode(34, node5);
        System.out.println(node6.toString());
        if (IntNode.hasCycle(node6)) {
            System.out.println("node6 has cycle");
        } else {
            System.out.println("node6 has no cycle");
        }
        node3.setLink(node6);
        if (IntNode.hasCycle(node6)) {
            System.out.println("node6 has cycle");
        } else {
            System.out.println("node6 has no cycle");
        }

        //check segregate_even_odd
        IntNode node7 = new IntNode(6, null);
        IntNode node8 = new IntNode(1, node7);
        IntNode node9 = new IntNode(4, node8);
        IntNode node10 = new IntNode(5, node9);
        IntNode node11 = new IntNode(10, node10);
        IntNode node12 = new IntNode(7, node11);
        IntNode node13 = new IntNode(8, node12);
        System.out.println("origin: " + node13.toString());
        IntNode.segregate_even_odd(node13);
        System.out.println("now: " + node13.toString());

        //check swap and reverse
        IntNode node14 = new IntNode(34, null);
        IntNode node15 = new IntNode(0, node14);
        IntNode node16 = new IntNode(28, node15);
        IntNode node17 = new IntNode(12, node16);
        //check the changeElement
        System.out.println("origin: " + node17.toString());
        IntNode.changeElement(node17, 2, 29);
        System.out.println("changed element: " + node17.toString());
        System.out.println("swap origin: " + node17.toString());
        node16.swap();
        System.out.println("swap now: " + node17.toString());
        System.out.println("reverse origin: " + node17.toString());
        node17 = IntNode.reverse(node17);
        System.out.println("reverse now: " + node17.toString());

        IntNode node18 = new IntNode(60, null);
        IntNode node19 = new IntNode(50, node18);
        IntNode node20 = new IntNode(40, node19);
        IntNode node21 = new IntNode(30, node20);
        IntNode node22 = new IntNode(20, node21);
        IntNode node23 = new IntNode(10, node22);
        System.out.println("rotate origin: " + node23.toString());
        node23 = IntNode.rotate(node23, 4);
        System.out.println("rotate now: " + node23.toString());
    } // end main
} // end class

