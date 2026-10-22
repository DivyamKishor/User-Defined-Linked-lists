class DNode {
    int val;
    DNode prev, next;

    DNode(int val) {
        this.val = val;
        this.prev = this.next = null;
    }
}

class DLL {
    private DNode head, tail;
    private int count;

    public void insertFirst(int val) {
        DNode node = new DNode(val);
        if (head == null) head = tail = node;
        else { node.next = head; head.prev = node; head = node; }
        count++;
    }

    public void insertLast(int val) {
        DNode node = new DNode(val);
        if (head == null) head = tail = node;
        else { tail.next = node; node.prev = tail; tail = node; }
        count++;
    }

    // Indexes start at 0.
    public void insertAt(int index, int val) {
        if (index < 0 || index > count) { System.out.println("Invalid index"); return; }
        if (index == 0) { insertFirst(val); return; }
        if (index == count) { insertLast(val); return; }
        DNode temp = head;
        for (int i = 0; i < index - 1; i++) temp = temp.next;
        DNode node = new DNode(val);
        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;
        count++;
    }

    public int deleteFirst() {
        if (head == null) { System.out.println("List is empty"); return -1; }
        int val = head.val;
        head = head.next;
        count--;
        if (head == null) tail = null;
        else head.prev = null;
        return val;
    }

    public int deleteLast() {
        if (tail == null) { System.out.println("List is empty"); return -1; }
        if (head == tail) return deleteFirst();
        int val = tail.val;
        tail = tail.prev;
        tail.next = null;
        count--;
        return val;
    }

    public int deleteAt(int index) {
        if (index < 0 || index >= count) { System.out.println("Invalid index"); return -1; }
        if (index == 0) return deleteFirst();
        if (index == count - 1) return deleteLast();
        DNode temp = head;
        for (int i = 0; i < index; i++) temp = temp.next;
        int val = temp.val;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        count--;
        return val;
    }

    public boolean search(int val) {
        DNode temp = head;
        while (temp != null) {
            if (temp.val == val) return true;
            temp = temp.next;
        }
        return false;
    }

    public int length() { return count; }

    public void displayForward() {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        DNode temp = tail;
        while (temp != null) {
            System.out.print(temp.val + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
}
