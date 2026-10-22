class CNode {
    int val;
    CNode next;

    CNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class CLL {
    private CNode head, tail;
    private int count;

    private void updateTailLink() {
        if (tail != null) tail.next = head;
    }

    public void insertFirst(int val) {
        CNode node = new CNode(val);
        if (head == null) head = tail = node;
        else { node.next = head; head = node; }
        updateTailLink();
        count++;
    }

    public void insertLast(int val) {
        CNode node = new CNode(val);
        if (head == null) head = tail = node;
        else { tail.next = node; tail = node; }
        updateTailLink();
        count++;
    }

    // Indexes start at 0.
    public void insertAt(int index, int val) {
        if (index < 0 || index > count) { System.out.println("Invalid index"); return; }
        if (index == 0) { insertFirst(val); return; }
        if (index == count) { insertLast(val); return; }
        CNode temp = head;
        for (int i = 0; i < index - 1; i++) temp = temp.next;
        CNode node = new CNode(val);
        node.next = temp.next;
        temp.next = node;
        count++;
    }

    public int deleteFirst() {
        if (head == null) { System.out.println("List is empty"); return -1; }
        int val = head.val;
        if (head == tail) head = tail = null;
        else { head = head.next; updateTailLink(); }
        count--;
        return val;
    }

    public int deleteLast() {
        if (head == null) { System.out.println("List is empty"); return -1; }
        if (head == tail) return deleteFirst();
        CNode temp = head;
        while (temp.next != tail) temp = temp.next;
        int val = tail.val;
        tail = temp;
        updateTailLink();
        count--;
        return val;
    }

    public int deleteAt(int index) {
        if (index < 0 || index >= count) { System.out.println("Invalid index"); return -1; }
        if (index == 0) return deleteFirst();
        if (index == count - 1) return deleteLast();
        CNode temp = head;
        for (int i = 0; i < index - 1; i++) temp = temp.next;
        int val = temp.next.val;
        temp.next = temp.next.next;
        count--;
        return val;
    }

    public boolean search(int val) {
        if (head == null) return false;
        CNode temp = head;
        do {
            if (temp.val == val) return true;
            temp = temp.next;
        } while (temp != head);
        return false;
    }

    public int length() { return count; }

    public void display() {
        if (head == null) { System.out.println("List is empty"); return; }
        CNode temp = head;
        do {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }
}
