import java.util.*;

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if (q1.isEmpty() && q2.isEmpty()) {
            q1.add(x);
        } else if (!q1.isEmpty()) {
            q1.add(x);
        } else {
            q2.add(x);
        }
    }

    public int pop() {
        if (empty()) {
            return -1;
        }

        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            return q1.remove();
        } else {
            while (q2.size() > 1) {
                q1.add(q2.remove());
            }
            return q2.remove();
        }
    }

    public int top() {
        if (empty()) {
            return -1;
        }

        int top;

        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }

            top = q1.remove();
            q2.add(top);

        } else {
            while (q2.size() > 1) {
                q1.add(q2.remove());
            }

            top = q2.remove();
            q1.add(top);
        }

        return top;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}