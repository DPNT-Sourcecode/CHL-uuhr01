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
       /* assertThat(checkliteSolution.checklite("AB"), is(80f));
        assertThat(checkliteSolution.checklite("ABE"), is(120f));
        assertThat(checkliteSolution.checklite("ABC"), is(100f));
        assertThat(checkliteSolution.checklite(""), is(0f));
        assertThat(checkliteSolution.checklite("123"), is(-1f));
        assertThat(checkliteSolution.checklite("AA"), is(100f));
        assertThat(checkliteSolution.checklite("AAA"), is(130f));
        assertThat(checkliteSolution.checklite("AAABB"), is(175f));


        assertThat(checkliteSolution.checklite("B"), is(30f));
        assertThat(checkliteSolution.checklite("BB"), is(45f));
        assertThat(checkliteSolution.checklite("BBE"), is(85f));
        assertThat(checkliteSolution.checklite("BBEE"), is(110f));
        assertThat(checkliteSolution.checklite("EEBB"), is(110f));


        assertThat(checkliteSolution.checklite("EEEB"), is(120f)); // 40 + 40 + 40 (free 30)
        assertThat(checkliteSolution.checklite("EEEEBB"), is(160f));
        assertThat(checkliteSolution.checklite("BEBEEE"), is(160f));

        assertThat(checkliteSolution.checklite("F"), is(10f));
        assertThat(checkliteSolution.checklite("FF"), is(20f));*/
        assertThat(checkliteSolution.checklite("FFF"), is(20f));
        assertThat(checkliteSolution.checklite("FFFF"), is(30f));
        assertThat(checkliteSolution.checklite("FFFFF"), is(40f));
        assertThat(checkliteSolution.checklite("FFFFFF"), is(40f));
    }

}



