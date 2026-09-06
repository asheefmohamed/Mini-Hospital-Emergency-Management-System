// Node representing each hospital visit
public class VisitNode {
    int visitId;
    String visitDate;
    String doctorName;
    String diagnosis;
    String treatment;
    VisitNode next;

    public VisitNode(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.next = null;
    }
}