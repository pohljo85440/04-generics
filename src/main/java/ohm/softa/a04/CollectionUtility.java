package ohm.softa.a04;

import java.util.Comparator;

public abstract class CollectionUtility {

    public static <T> SimpleList<T> sort(SimpleList<T> list, Comparator<T> comperator) {
        return bubbleSort(list, comperator);
    }

    private static <T> SimpleList<T> bubbleSort(SimpleList<T> list, Comparator<T> comperator) {
        int listSize = list.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - i - 1; j++) {
                if (comperator.compare(list.getAtIndex(j), list.getAtIndex(j + 1)) > 0) {
                    T temp = list.getAtIndex(j);
                    list.setAtIndex(j, list.getAtIndex(j + 1));
                    list.setAtIndex(j + 1, temp);
                }
            }
        }
        return list;
    }
}
