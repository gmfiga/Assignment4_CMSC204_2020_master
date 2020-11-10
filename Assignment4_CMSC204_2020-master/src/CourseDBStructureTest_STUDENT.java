import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 *
 * @author Gabriel Martins Figueiredo
 */
public class CourseDBStructureTest_STUDENT {
    CourseDBStructure cds, testStructure;

    @Before
    public void setUp() throws Exception {
        cds = new CourseDBStructure(40);
        testStructure = new CourseDBStructure("Testing", 6000);
    }

    @After
    public void tearDown() throws Exception {
        cds = testStructure = null;
    }

    /**
     * Test the tableSize for CourseDBStructures constructed
     * with both constructors
     */
    @Test
    public void testGetTableSize() {
        assertEquals(40, cds.getTableSize());
        assertEquals(6000, testStructure.getTableSize());
    }

    /**
     * Test the hashTable for CourseDBStructures constructed
     * with both constructors
     */
    @Test
    public void testHashTable() {
        assertEquals(40, cds.hashTable.length);
        CourseDBElement cde = new CourseDBElement("TEST", 11111, 4, "testRoom", "Test Professor");
        cds.add(cde);
        LinkedList<CourseDBElement> list = cds.hashTable[cde.hashCode() % cds.getTableSize()];
        assertEquals(11111, list.get(0).getCRN());

        cds = new CourseDBStructure("Testing", 35);
        assertEquals(35, cds.hashTable.length);
        cds.add(cde);
        list = cds.hashTable[cde.hashCode() % 35];
        assertEquals(11111, list.get(0).getCRN());
    }
}