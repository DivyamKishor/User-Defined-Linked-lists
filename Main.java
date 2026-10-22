public class Main {
    public static void main(String[] args) {
        System.out.println("SINGLY LINKED LIST");
        SLL singly = new SLL();
        singly.insertFirst(20);
        singly.insertFirst(10);
        singly.insertLast(40);
        singly.insertAt(2, 30);
        singly.display();
        System.out.println("Length: " + singly.length());
        System.out.println("Search 30: " + singly.search(30));
        singly.deleteAt(2);
        singly.display();

        System.out.println("\nDOUBLY LINKED LIST");
        DLL doubly = new DLL();
        doubly.insertFirst(20);
        doubly.insertFirst(10);
        doubly.insertLast(40);
        doubly.insertAt(2, 30);
        doubly.displayForward();
        doubly.displayBackward();
        System.out.println("Length: " + doubly.length());
        doubly.deleteFirst();
        doubly.displayForward();

        System.out.println("\nCIRCULAR LINKED LIST");
        CLL circular = new CLL();
        circular.insertFirst(20);
        circular.insertFirst(10);
        circular.insertLast(40);
        circular.insertAt(2, 30);
        circular.display();
        System.out.println("Length: " + circular.length());
        System.out.println("Search 40: " + circular.search(40));
        circular.deleteLast();
        circular.display();
    }
}
