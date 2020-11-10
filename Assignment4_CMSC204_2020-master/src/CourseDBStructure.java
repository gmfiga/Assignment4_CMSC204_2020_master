import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Course Database Structure
 *
 * @author Gabriel Martins Figueiredo
 */
public class CourseDBStructure implements CourseDBStructureInterface {

    public LinkedList<CourseDBElement>[] hashTable;


    public CourseDBStructure(int numberOfCourses) {
        hashTable = new LinkedList[numberOfCourses];
    }

    public CourseDBStructure(String string, int hashTableSize){
        hashTable = new LinkedList[hashTableSize];
    }

    /**
     * Table size getter
     * @return table size
     */
    public int getTableSize() {
        return hashTable.length;
    }

    /**
     * Uses the hashcode of the CourseDatabaseElement to see if it is
     * in the hashtable.
     *
     * If the CourseDatabaseElement does not exist in the hashtable,
     * add it to the hashtable.
     *
     * @param cde the CDE to be added
     */
    public void add(CourseDBElement cde) {
        int hashCode = cde.hashCode();
        int index = hashCode%hashTable.length;

        if (hashTable[index] == null){
            hashTable[index] = new LinkedList<CourseDBElement>();
            hashTable[index].add(cde);
        }

        else if (hashTable[index] != null){
            hashTable[index].add(cde);
        }
    }

    /**
     * Get cde based on crn
     * @param crn - course crn
     * @return cde
     * @throws IOException
     */
    @Override
    public CourseDBElement get(int crn) throws IOException {
        String stringCRN = Integer.toString(crn);
        int hashCode = stringCRN.hashCode();
        int index = hashCode%hashTable.length;
        Iterator<CourseDBElement> iterator= hashTable[index].listIterator();

        while (iterator.hasNext()){
            CourseDBElement element = iterator.next();
            if (element.getCRN() == crn){
                return element;
            }
        }

        return null;
    }

}
