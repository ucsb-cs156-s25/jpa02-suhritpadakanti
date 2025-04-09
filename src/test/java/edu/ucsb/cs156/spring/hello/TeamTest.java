package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_when_same_object() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_returns_false_when_other_object_is_different_class() {
        String notATeam = "I am not a team";
        assertEquals(false, team.equals(notATeam));
    }

    @Test
    public void equals_returns_true_when_all_fields_equal() {
        Team team2 = new Team("test-team");
        assertEquals(true, team.equals(team2));
        assertEquals(true, team2.equals(team));
    }

    @Test
    public void equals_returns_false_when_members_differ() {
        Team team2 = new Team("test-team");
        team2.getMembers().add("Alice");
        assertEquals(false, team.equals(team2));
        assertEquals(false, team2.equals(team));
    }
    
    @Test
    public void equals_returns_false_when_names_differ() {
        Team team2 = new Team("another-team");
        assertEquals(false, team.equals(team2));
        assertEquals(false, team2.equals(team));
    }

    @Test
    public void hashCode_test() {
        Team t = new Team(); 
        int result = t.hashCode();
        int expectedResult = 1; 
        assertEquals(expectedResult, result);
    }




    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
}
