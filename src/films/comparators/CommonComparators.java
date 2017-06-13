package films.comparators;

import java.util.Comparator;

public class CommonComparators {
    private CommonComparators() {
    }

    public static <T> Comparator<T> multiCriterion(Comparator<T> comparators) {
        return new Comparator<T>() {
            @Override
            public int compare(T a, T b) {
//                for (Comparator<T> comparator : comparators) {
                // @todo Rename to "comparator" after fix.
                    int cmp = comparators.compare(a, b);
                    if (cmp != 0) return cmp;
//                }

                return 0;
            }
        };
    }
}
