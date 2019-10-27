package befaster.solutions.CHL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class CheckliteSolutionTest {

    CheckliteSolution checkliteSolution;

    @Before
    public void setup() {
        checkliteSolution = new CheckliteSolution();
    }

    @Test
    public void checklite() {
        assertThat(checkliteSolution.checklite("AB"), is(2));
        assertThat(checkliteSolution.checklite("ABE"), is(-1));
        assertThat(checkliteSolution.checklite("ABC"), is(3));
        assertThat(checkliteSolution.checklite(""), is(0));
        assertThat(checkliteSolution.checklite("123"), is(-1));
        assertThat(checkliteSolution.checklite("abc"), is(3)); // what about this one..
    }
}



