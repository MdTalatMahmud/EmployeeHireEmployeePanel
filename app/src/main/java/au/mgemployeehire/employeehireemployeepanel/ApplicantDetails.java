package au.mgemployeehire.employeehireemployeepanel;

public class ApplicantDetails {

    String applicantName;
    String applicantContactNumber;
    String applicantEmail;

    public ApplicantDetails(String applicantName, String applicantContactNumber, String applicantEmail) {
        this.applicantName = applicantName;
        this.applicantContactNumber = applicantContactNumber;
        this.applicantEmail = applicantEmail;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantContactNumber() {
        return applicantContactNumber;
    }

    public void setApplicantContactNumber(String applicantContactNumber) {
        this.applicantContactNumber = applicantContactNumber;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }
}
