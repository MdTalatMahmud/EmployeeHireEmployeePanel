package au.mgemployeehire.employeehireemployeepanel;

public class ApplicantDetails {

    String applicantName;
    String applicantContactNumber;
    String applicantEmail;
    String applicantEducationalQualification;
    String applicantExperience;
    String applicantLicense;
    String applicantAvailability;

    public ApplicantDetails(String applicantName, String applicantContactNumber, String applicantEmail, String applicantEducationalQualification, String applicantExperience, String applicantLicense, String applicantAvailability) {
        this.applicantName = applicantName;
        this.applicantContactNumber = applicantContactNumber;
        this.applicantEmail = applicantEmail;
        this.applicantEducationalQualification = applicantEducationalQualification;
        this.applicantExperience = applicantExperience;
        this.applicantLicense = applicantLicense;
        this.applicantAvailability = applicantAvailability;
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

    public String getApplicantEducationalQualification() {
        return applicantEducationalQualification;
    }

    public void setApplicantEducationalQualification(String applicantEducationalQualification) {
        this.applicantEducationalQualification = applicantEducationalQualification;
    }

    public String getApplicantAvailability() {
        return applicantAvailability;
    }

    public void setApplicantAvailability(String applicantAvailability) {
        this.applicantAvailability = applicantAvailability;
    }
}
