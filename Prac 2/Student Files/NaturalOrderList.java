
public class NaturalOrderList<T extends Comparable<T>> extends SelfOrderingList<T> {
    @Override
    public SelfOrderingList<T> getBlankList() {

        SelfOrderingList<T> newNaturalOrder = new NaturalOrderList<T>();
        return newNaturalOrder;
    }

    @Override
    public void access(T data) {

        /// do nothing

    }

    @Override
    public void insert(T data) {

    }

}
