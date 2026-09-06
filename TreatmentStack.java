import java.util.Stack;

public class TreatmentStack {
    private final Stack<String> stack = new Stack<>();

    // Push
    public void push(String treatmentRecord) {
        stack.push(treatmentRecord);
        System.out.println("Treatment record stored in stack.");
    }

    // Pop
    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty! No completed treatments to remove.");
            return;
        }
        String removed = stack.pop();
        System.out.println("Removed recent treatment: " + removed);
    }

    // Display
    public void displayStack() {
        if (stack.isEmpty()) {
            System.out.println("Treatment history stack is empty.");
            return;
        }
        System.out.println("--- Completed Treatment Records (LIFO) ---");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }
}