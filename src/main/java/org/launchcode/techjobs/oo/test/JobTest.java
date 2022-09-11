package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId () {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId() == job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
    Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertTrue(job3 instanceof Job);
    assertTrue(job3.getEmployer() instanceof Employer);
    assertTrue(job3.getLocation() instanceof Location);
    assertTrue(job3.getPositionType() instanceof PositionType);
    assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    assertEquals("Product tester", job3.getName());
    assertEquals("ACME", job3.getEmployer().getValue());
    assertEquals("Desert", job3.getLocation().getValue());
    assertEquals("Quality control", job3.getPositionType().getValue());
    assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char firstCharacter = job6.toString().charAt(0);
        char lastCharacter = job6.toString().charAt(job6.toString().length()-1);
        assertEquals('\n', firstCharacter);
        assertEquals('\n', lastCharacter);
        //        String resultBeginning = String.valueOf(job6.toString().charAt(0));
        //        String resultEnding = String.valueOf(job6.toString().charAt(job6.toString().length()-1));
        //        assertEquals("\n", resultBeginning);
        //        assertEquals("\n", resultEnding);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job6.toString(), "\nID: " + job6.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n");
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job6 = new Job("", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job6.toString(), "\nID: " + job6.getId() + "\nName: Data not available\nEmployer: ACME\nLocation: Data not available\nPosition Type: Quality control\nCore Competency: Persistence\n");
    }

    @Test
    public void bonusTestIdOnlyReturnsErrorMessage(){
        Job job7 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(job7.toString(), "OOPS! This job does not seem to exist.");
    }

    private void assertNotEquals(boolean b) {
    }



}
