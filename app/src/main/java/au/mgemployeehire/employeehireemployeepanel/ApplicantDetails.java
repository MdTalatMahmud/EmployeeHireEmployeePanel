package au.mgemployeehire.employeehireemployeepanel;

public class ApplicantDetails {

    String applicantName;
    String applicantContactNumber;
    String applicantEmail;
    String applicantExperience;
    String applicantLicense;

    public ApplicantDetails(String applicantName, String applicantContactNumber, String applicantEmail, String applicantExperience, String applicantLicense) {
        this.applicantName = applicantName;
        this.applicantContactNumber = applicantContactNumber;
        this.applicantEmail = applicantEmail;
        this.applicantExperience = applicantExperience;
        this.applicantLicense = applicantLicense;
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

    public String getApplicantExperience() {
        return applicantExperience;
    }

    public void setApplicantExperience(String applicantExperience) {
        this.applicantExperience = applicantExperience;
    }

    public String getApplicantLicense() {
        return applicantLicense;
    }

    public void setApplicantLicense(String applicantLicense) {
        this.applicantLicense = applicantLicense;
    }
}
