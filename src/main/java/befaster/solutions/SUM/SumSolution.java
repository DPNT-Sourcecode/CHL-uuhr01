package befaster.solutions.SUM;

import befaster.runner.SolutionNotImplementedException;
import com.google.common.base.Preconditions;

@SuppressWarnings("unused")
public class SumSolution {

    public int compute(int x, int y) {
        Preconditions.checkArgument(x >= 0);
        Preconditions.checkArgument(x <= 100);
        Preconditions.checkArgument(y >= 0);
        Preconditions.checkArgument(y <= 100);
        return x + y;
    }

}


