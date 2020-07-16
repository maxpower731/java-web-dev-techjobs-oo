package org.launchcode.techjobs_oo.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

public class JobTest {

    private Employer newEmployer;
    private Location newLocation;
    private PositionType newPositionType;
    private CoreCompetency newCoreCompetency;
    private Job job1;
    private Job job2;

    @Before
    public void initObjects() {
        newEmployer = new Employer("LaunchCode");
        newLocation = new Location("Tampa");
        newPositionType = new PositionType("Software Developer");
        newCoreCompetency = new CoreCompetency("Java");
        job1 = new Job("Job1", newEmployer, newLocation, newPositionType, newCoreCompetency);
        job2 = new Job("Job2", newEmployer, newLocation, newPositionType, newCoreCompetency);
    }

    @Test
    public void testSettingJobId() {
        assertFalse(job1.equals(job2));
        assertFalse(job1.getId() == job2.getId());
        assertTrue(job2.getId() - job1.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getEmployer().toString() == "ACME");
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getLocation().toString() == "Desert");
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getPositionType().toString() == "Quality control");
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job3.getCoreCompetency().toString() == "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence")).equals(new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"))));
    }

    @Test
    public void testBlankLineBeforeAndAfterJobInfo() {
        //Convert string to char array to check element 0 and final element for char \n
        char[] hasLineBreakChar = job1.toString().toCharArray();
        assertTrue(hasLineBreakChar[0] == '\n' && hasLineBreakChar[hasLineBreakChar.length-1] == '\n');
    }

    @Test
    public void testLabelWithNewLineForEachField() {
        assertTrue(job1.toString().contains("ID: "));
        assertTrue(job1.toString().contains("\nName: "));
        assertTrue(job1.toString().contains("\nEmployer: "));
        assertTrue(job1.toString().contains("\nLocation: "));
        assertTrue(job1.toString().contains("\nPosition Type: "));
        assertTrue(job1.toString().contains("\nCore Competency: "));
    }

    @Test
    public void testEmptyFieldReturnsDataNotAvailable() {
        Job job = new Job("Foo", new Employer("") ,new Location("Texas"), new PositionType("Programmer"), new CoreCompetency("Awesomeness"));
        assertTrue(job.toString().contains("Employer: Data not available"));
        assertTrue(job.toString().contains("Location: Texas"));
    }

    @Test
    public void testAllEmptyDataFieldsReturnsOOPSMessage() {
        Job job = new Job("", new Employer("") ,new Location(""), new PositionType(""), new CoreCompetency(""));
        assertTrue(job.toString() == "OOPS! This job does not seem to exist.");
    }



}
