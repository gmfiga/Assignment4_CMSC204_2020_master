/**
 * Course Datebase Element
 *
 * @author Gabriel Martins Figueiredo
 */
public class CourseDBElement implements Comparable {

    String courseId;
    int CRN;
    int numberOfCredits;
    String roomNumber;
    String instructorName;


    public CourseDBElement() {
    }

    /**
     * Constructor
     * @param courseId - course id
     * @param CRN - course crn
     * @param numberOfCredits - course number of credits
     * @param roomNumber - course room number
     * @param instructorName - course instructor name
     */
    public CourseDBElement(String courseId, int CRN, int numberOfCredits, String roomNumber, String instructorName) {
        this.courseId = courseId;
        this.CRN = CRN;
        this.numberOfCredits = numberOfCredits;
        this.roomNumber = roomNumber;
        this.instructorName = instructorName;
    }

    /**
     * CRN getter
     * @return crn
     */
    public int getCRN() {
        return CRN;
    }

    /**
     * ID getter
     * @return courseID
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * ID setter
     * @return this
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * NumberOfCredits getter
     * @return NumberOfCredits
     */
    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    /**
     * NumberOfCredits setter
     * @param numberOfCredits
     */
    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    /**
     * Room Number getter
     * @return Room Number
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Room Number setter
     * @param roomNumber
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Instructor Name getter
     * @return instructor name
     */
    public String getInstructorName() {
        return instructorName;
    }

    /**
     * Instructor Name setter
     * @param instructorName
     */
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    /**
     * Compare to method
     * @param element
     * @return
     */
    @Override
    public int compareTo(CourseDBElement element) {
        if (this.CRN > element.CRN)
            return 1;
        else if (this.CRN < element.CRN)
            return -1;
        else
            return 0;
    }

    /**
     * HashCode method
     * @return hashCode
     */
    @Override
    public int hashCode() {
        String crn = Integer.toString(CRN);
        int hashCode = crn.hashCode();
        return hashCode;
    }

    public void setCRN(int crn) {
        this.CRN = crn;
    }
}
