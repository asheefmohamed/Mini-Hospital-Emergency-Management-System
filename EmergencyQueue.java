import java.util.LinkedList;

public class EmergencyQueue {
    private final LinkedList<Patient> queue = new LinkedList<>();

    // Enqueue
    public void enqueue(Patient patient) {
        queue.addLast(patient);
        System.out.println("Patient " + patient.name + " added to emergency queue.");
    }

    // Dequeue
    public Patient dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty! No waiting patients.");
            return null;
        }
        Patient p = queue.removeFirst();
        System.out.println("Patient " + p.name + " moved to treatment room.");
        return p;
    }

    // Display
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Emergency Queue is currently empty.");
            return;
        }
        System.out.println("--- Current Emergency Waiting Queue (FIFO) ---");
        for (Patient p : queue) {
            System.out.println("ID: " + p.patientId + " | Name: " + p.name + " | Condition: " + p.medicalCondition);
        }
    }
}