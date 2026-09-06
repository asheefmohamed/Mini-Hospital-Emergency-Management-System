// Patient record class containing profile details and visit history list
public class Patient {
    int patientId;
    String name;
    int age;
    String contact;
    String medicalCondition;

    // Binary Search Tree Pointers
    Patient left;
    Patient right;

    // 4. Singly Linked List for Visit History
    VisitNode visitHead;

    public Patient(int patientId, String name, int age, String contact, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.medicalCondition = medicalCondition;
        this.left = null;
        this.right = null;
        this.visitHead = null;
    }

    // Add visit to linked list
    public void addVisit(int visitId, String date, String doctor, String diagnosis, String treatment) {
        VisitNode newVisit = new VisitNode(visitId, date, doctor, diagnosis, treatment);
        if (visitHead == null) {
            visitHead = newVisit;
        } else {
            VisitNode temp = visitHead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newVisit;
        }
        System.out.println("Visit added successfully!");
    }

    // Remove visit from linked list
    public void removeVisit(int visitId) {
        if (visitHead == null) {
            System.out.println("No visits found to remove.");
            return;
        }
        if (visitHead.visitId == visitId) {
            visitHead = visitHead.next;
            System.out.println("Visit removed successfully!");
            return;
        }
        VisitNode current = visitHead;
        while (current.next != null && current.next.visitId != visitId) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Visit ID not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Visit removed successfully!");
        }
    }

    // Search and display a visit
    public void searchVisit(int visitId) {
        VisitNode temp = visitHead;
        while (temp != null) {
            if (temp.visitId == visitId) {
                System.out.println("Visit Found -> ID: " + temp.visitId + " | Date: " + temp.visitDate + 
                                   " | Doctor: " + temp.doctorName + " | Diagnosis: " + temp.diagnosis + 
                                   " | Treatment: " + temp.treatment);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Visit record not found.");
    }

    // Display all visit history
    public void displayVisits() {
        if (visitHead == null) {
            System.out.println("No previous visits recorded.");
            return;
        }
        VisitNode temp = visitHead;
        System.out.println("--- Visit History for " + name + " ---");
        while (temp != null) {
            System.out.println("ID: " + temp.visitId + " | Date: " + temp.visitDate + 
                               " | Doctor: " + temp.doctorName + " | Diagnosis: " + temp.diagnosis + 
                               " | Treatment: " + temp.treatment);
            temp = temp.next;
        }
    }
}