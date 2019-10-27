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
        assertThat(checkliteSolution.checklite("AB"), is(80f));
        assertThat(checkliteSolution.checklite("ABE"), is(-1f));
        assertThat(checkliteSolution.checklite("ABC"), is(100f));
        assertThat(checkliteSolution.checklite(""), is(0f));
        assertThat(checkliteSolution.checklite("123"), is(-1f));
        assertThat(checkliteSolution.checklite("AA"), is(100f));
        assertThat(checkliteSolution.checklite("AAA"), is(130f));
        assertThat(checkliteSolution.checklite("AAABB"), is(175f));
    }

}

