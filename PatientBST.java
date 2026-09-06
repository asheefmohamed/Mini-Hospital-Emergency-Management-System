// Binary Search Tree for Patient Records
public class PatientBST {
    private Patient root;

    // Insert Patient
    public void insert(Patient newPatient) {
        root = insertRec(root, newPatient);
    }

    private Patient insertRec(Patient root, Patient newPatient) {
        if (root == null) {
            return newPatient;
        }
        if (newPatient.patientId < root.patientId) {
            root.left = insertRec(root.left, newPatient);
        } else if (newPatient.patientId > root.patientId) {
            root.right = insertRec(root.right, newPatient);
        } else {
            System.out.println("Patient ID already exists!");
        }
        return root;
    }

    // Search Patient
    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(Patient root, int patientId) {
        if (root == null || root.patientId == patientId) {
            return root;
        }
        if (patientId < root.patientId) {
            return searchRec(root.left, patientId);
        }
        return searchRec(root.right, patientId);
    }

    // Delete Patient
    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private Patient deleteRec(Patient root, int patientId) {
        if (root == null) return null;

        if (patientId < root.patientId) {
            root.left = deleteRec(root.left, patientId);
        } else if (patientId > root.patientId) {
            root.right = deleteRec(root.right, patientId);
        } else {
            // Node with 1 or 0 children
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Node with 2 children: get in-order successor
            Patient temp = minValue(root.right);
            root.patientId = temp.patientId;
            root.name = temp.name;
            root.age = temp.age;
            root.contact = temp.contact;
            root.medicalCondition = temp.medicalCondition;
            root.visitHead = temp.visitHead;

            root.right = deleteRec(root.right, temp.patientId);
        }
        return root;
    }

    private Patient minValue(Patient root) {
        Patient temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    // In-order traversal
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patient records found.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(Patient root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println("ID: " + root.patientId + " | Name: " + root.name + 
                               " | Age: " + root.age + " | Contact: " + root.contact + 
                               " | Condition: " + root.medicalCondition);
            inOrderRec(root.right);
        }
    }
}