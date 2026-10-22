class SNode {
    int val;
    SNode next;

    SNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class SLL {
    private SNode head, tail;
    private int count;

    public void insertFirst(int val) {
        SNode node = new SNode(val);
        if (head == null) head = tail = node;
        else { node.next = head; head = node; }
        count++;
    }

    public void insertLast(int val) {
        SNode node = new SNode(val);
        if (head == null) head = tail = node;
        else { tail.next = node; tail = node; }
        count++;
    }

    // Indexes start at 0.
    public void insertAt(int index, int val) {
        if (index < 0 || index > count) { System.out.println("Invalid index"); return; }
        if (index == 0) { insertFirst(val); return; }
        if (index == count) { insertLast(val); return; }
        SNode temp = head;
        for (int i = 0; i < index - 1; i++) temp = temp.next;
        SNode node = new SNode(val);
        node.next = temp.next;
        temp.next = node;
        count++;
    }

    public int deleteFirst() {
        if (head == null) { System.out.println("List is empty"); return -1; }
        int val = head.val;
        head = head.next;
        count--;
        if (head == null) tail = null;
        return val;
    }

    public int deleteLast() {
        if (head == null) { System.out.println("List is empty"); return -1; }
        if (head == tail) return deleteFirst();
        SNode temp = head;
        while (temp.next != tail) temp = temp.next;
        int val = tail.val;
        temp.next = null;
        tail = temp;
        count--;
        return val;
    }

    public int deleteAt(int index) {
        if (index < 0 || index >= count) { System.out.println("Invalid index"); return -1; }
        if (index == 0) return deleteFirst();
        if (index == count - 1) return deleteLast();
        SNode temp = head;
        for (int i = 0; i < index - 1; i++) temp = temp.next;
        int val = temp.next.val;
        temp.next = temp.next.next;
        count--;
        return val;
    }

    public boolean search(int val) {
        SNode temp = head;
        while (temp != null) {
            if (temp.val == val) return true;
            temp = temp.next;
        }
        return false;
    }

    public int length() { return count; }

    public void display() {
        SNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
