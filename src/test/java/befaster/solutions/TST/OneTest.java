package befaster.solutions.TST;

import befaster.solutions.HLO.HelloSolution;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class OneTest {
    private One one;

    @Before
    public void name() {
        one = new One();
    }

    @Test
    public void run() {
        assertThat(one.apply(), equalTo(1));
    }

    @Test
    public void test() {
        HelloSolution hello = new HelloSolution();
        assertThat(hello.hello("John"), is("Hello, John!"));
    }
}