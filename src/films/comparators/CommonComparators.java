package films.comparators;

import java.util.Comparator;

public class CommonComparators {
    private CommonComparators() {
    }

    @SafeVarargs
    public static <T> Comparator<T> multiCriterion(Comparator<T>... comparators) {
        return (a, b) -> {
            for (Comparator<T> comparator : comparators) {
                int cmp = comparator.compare(a, b);
                if (cmp != 0) return cmp;
            }

            return 0;
        };
    }
}
