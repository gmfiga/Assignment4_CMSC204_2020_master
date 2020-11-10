import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 *
 * @author Gabriel Martins Figueiredo
 *
 */
public class CourseDBManagerTest_STUDENT {
    private CourseDBManagerInterface dataMgr = new CourseDBManager();

    /**
     * Create an instance of CourseDBManager
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        dataMgr = new CourseDBManager();
    }

    /**
     * Set dataMgr reference to null
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        dataMgr = null;
    }

    /**
     * Test for the add method
     */
    @Test
    public void testAddToDB() {
        try {
            dataMgr.add("TEST",11111,4,"testRoom","Test Professor");
        }
        catch(Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    /**
     * Test for the showAll method
     */
    @Test
    public void testShowAll() {
        dataMgr.add("TEST",11111,4,"testRoom","Test Professor");
        dataMgr.add("TEST2",22222,4,"testRoom2","Test Professor2");
        ArrayList<String> list = dataMgr.showAll();

        assertEquals(list.get(0),"\nCourse:TEST CRN:11111 Credits:4 Instructor:Test Professor Room:testRoom");
        assertEquals(list.get(1),"\nCourse:TEST2 CRN:22222 Credits:4 Instructor:Test Professor2 Room:testRoom2");

    }
    /**
     * Test for the read method
     */
    @Test
    public void testRead() {
        try {
            File inputFile = new File("Test2.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.println("TEST 11111 4 testRoom Test Professor");
            inFile.print("TEST2 22222 4 testRoom2 Test Professor2");

            inFile.close();
            dataMgr.readFile(inputFile);
            //System.out.println(dataMgr.showAll());
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }
}