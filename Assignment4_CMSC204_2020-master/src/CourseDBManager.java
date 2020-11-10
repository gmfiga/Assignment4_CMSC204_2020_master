import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Course Database Manager
 *
 * @author Gabriel Martins Figueiredo
 */
public class CourseDBManager implements CourseDBManagerInterface {

    CourseDBStructure cds;

    /**
     * Constructor
     */
    public CourseDBManager() {
        this.cds = new CourseDBStructure(100);
    }

    /**
     * Constructor
     * @param id
     * @param crn
     * @param credits
     * @param roomNum
     * @param instructor
     */
    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        CourseDBElement cde = new CourseDBElement(id, crn, credits, roomNum, instructor);
        cds.add(cde);
    }

    /**
     * Get course based on crn. Uses CDS get method
     * @param crn - course crn
     * @return cde
     */
    @Override
    public CourseDBElement get(int crn) {
        try {
            return cds.get(crn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * File reader
     * @param input - file
     * @throws FileNotFoundException
     */
    @Override
    public void readFile(File input) throws FileNotFoundException {
        Scanner file;
        try {
            file = new Scanner(input);
        } catch (FileNotFoundException e){
            throw new FileNotFoundException("File not found");
        }

        cds = new CourseDBStructure(100);

        while(file.hasNextLine()){
            Scanner scanner = new Scanner(file.nextLine());
            String courseId = scanner.next();
            int CRN = scanner.nextInt();
            int numberOfCredits = scanner.nextInt();
            String roomNumber = scanner.next();
            String instructorName = "";
            while (scanner.hasNext()){
                instructorName += scanner.next()+ " ";
            }

            CourseDBElement cde = new CourseDBElement(courseId, CRN, numberOfCredits, roomNumber, instructorName);
            cds.add(cde);
        }

    }

    /**
     * Show all courses in data base
     * @return Array list of courses
     */
    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> list = new ArrayList<String>();
        int numberOfCourses = cds.getTableSize();

        for (LinkedList linkedList: cds.hashTable) {
            if (linkedList!=null) {
                CourseDBElement[] cdeArray = (CourseDBElement[]) linkedList.toArray(new CourseDBElement[linkedList.size()]);

                for (CourseDBElement cde: cdeArray) {
                    String courseInfo = "\nCourse:"+cde.getCourseId()+" CRN:"+cde.getCRN()+
                            " Credits:"+cde.getNumberOfCredits()+" Instructor:"+cde.getInstructorName()+
                            " Room:"+cde.getRoomNumber();
                    list.add(courseInfo);
                }

            }
        }



        return list;
    }

}
