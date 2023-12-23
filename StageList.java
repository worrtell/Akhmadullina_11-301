import java.util.Scanner;

public class StageList implements ChooseStage {
    Scanner in = new Scanner(System.in);
    Node cur;
    Node head;
    public void CreateList() {
        Node cur = new Node();
        head = cur;
        for (int i = 0; i < 4; i++) {
            cur.next = new Node();
            cur = cur.next;
        }
        cur = head;
        cur.stage = new Project();
        Node cur2 = cur;
        cur = cur.next;
        cur.stage = new Base();
        cur.prev = cur2;
        cur2 = cur2.next;
        cur = cur.next;
        cur.stage = new Walls();
        cur.prev = cur2;
        cur2 = cur2.next;
        cur = cur.next;
        cur.stage = new Roof();
        cur.prev = cur2;
        cur2 = cur2.next;
        cur = cur.next;
        cur.stage = new Finishing();
        cur.prev = cur2;
        this.cur = head;
    }

    public Stage prev() {
        this.cur = cur.prev;
        System.out.println("Set a new status: 1-done, 2-being_done, 3-planned, 4-rejected");
        int ans = in.nextInt();
        switch(ans) {
            case 1: cur.stage.status = Status.done; break;
            case 2: cur.stage.status = Status.being_done; break;
            case 3: cur.stage.status = Status.planned; break;
            case 4: cur.stage.status = Status.rejected; break;
        }
        System.out.println(cur.stage.status + cur.stage.name );
        return cur.stage;
    }


    public Stage next() {
        System.out.println("Set a status: 1-done, 2-being_done, 3-planned, 4-rejected");
        int ans = in.nextInt();
        switch (ans) {
            case 1:
                cur.stage.status = Status.done;
                break;
            case 2:
                cur.stage.status = Status.being_done;
                break;
            case 3:
                cur.stage.status = Status.planned;
                break;
            case 4:
                cur.stage.status = Status.rejected;
                break;
        }
        System.out.println(cur.stage.status);
        if (cur.stage.status != Status.done) {
            cur.stage = null;
        }
        Stage n = cur.stage;
        if (cur.next != null) {
            this.cur = cur.next;
        } else {
            this.cur = head;
        }
        return n;
    }
}
