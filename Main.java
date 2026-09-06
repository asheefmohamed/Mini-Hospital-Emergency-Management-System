import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue();
        TreatmentStack stack = new TreatmentStack();
        try (Scanner sc = new Scanner(System.in)) {

            while (true) {
            System.out.println("\n===== MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Patient Record (BST)");
            System.out.println("2. Search Patient Record (BST)");
            System.out.println("3. Delete Patient Record (BST)");
            System.out.println("4. Display All Patients (In-Order BST)");
            System.out.println("5. Add to Emergency Queue (Enqueue)");
            System.out.println("6. Call Next Patient for Treatment (Dequeue)");
            System.out.println("7. Display Waiting Queue");
            System.out.println("8. Add Completed Treatment Record (Stack Push)");
            System.out.println("9. Remove Last Treatment Record (Stack Pop)");
            System.out.println("10. Display Treatment Records (Stack)");
            System.out.println("11. Manage Patient Visit History (Singly Linked List)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Contact: "); String contact = sc.nextLine();
                    System.out.print("Condition: "); String cond = sc.nextLine();
                    bst.insert(new Patient(id, name, age, contact, cond));
                    System.out.println("Patient added to BST successfully!");
                }
                case 2 -> {
                    System.out.print("Enter Patient ID: ");
                    Patient found = bst.search(sc.nextInt());
                    if (found != null) System.out.println("Found: " + found.name + " (" + found.medicalCondition + ")");
                    else System.out.println("Patient not found.");
                }
                case 3 -> {
                    System.out.print("Enter Patient ID to delete: ");
                    bst.delete(sc.nextInt());
                    System.out.println("Delete operation completed.");
                }
                case 4 -> {
                    bst.displayInOrder();
                }
                case 5 -> {
                    System.out.print("Enter Patient ID for Queue: ");
                    Patient qp = bst.search(sc.nextInt());
                    if (qp != null) queue.enqueue(qp);
                    else System.out.println("Patient ID not found in system!");
                }
                case 6 -> {
                    queue.dequeue();
                }
                case 7 -> {
                    queue.displayQueue();
                }
                case 8 -> {
                    System.out.print("Enter completed treatment details: ");
                    stack.push(sc.nextLine());
                }
                case 9 -> {
                    stack.pop();
                }
                case 10 -> {
                    stack.displayStack();
                }
                case 11 -> {
                    System.out.print("Enter Patient ID: ");
                    Patient lp = bst.search(sc.nextInt());
                    if (lp == null) {
                        System.out.println("Patient not found.");
                        continue;
                    }
                    System.out.println("1. Add Visit | 2. Remove Visit | 3. Search Visit | 4. View Visits");
                    int vChoice = sc.nextInt(); sc.nextLine();
                    switch (vChoice) {
                        case 1 -> {
                            System.out.print("Visit ID: "); int vid = sc.nextInt(); sc.nextLine();
                            System.out.print("Date: "); String date = sc.nextLine();
                            System.out.print("Doctor: "); String doc = sc.nextLine();
                            System.out.print("Diagnosis: "); String diag = sc.nextLine();
                            System.out.print("Treatment: "); String trt = sc.nextLine();
                            lp.addVisit(vid, date, doc, diag, trt);
                        }
                        case 2 -> {
                            System.out.print("Enter Visit ID to remove: ");
                            lp.removeVisit(sc.nextInt());
                        }
                        case 3 -> {
                            System.out.print("Enter Visit ID to search: ");
                            lp.searchVisit(sc.nextInt());
                        }
                        case 4 -> lp.displayVisits();
                        default -> System.out.println("Invalid visit choice!");
                    }
                }
                case 0 -> {
                    System.out.println("Exiting System...");
                    return;
                }
                default -> {
                    System.out.println("Invalid Choice!");
                }
            }
            }
        }
    }
}