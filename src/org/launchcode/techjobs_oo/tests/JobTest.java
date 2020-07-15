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

}
