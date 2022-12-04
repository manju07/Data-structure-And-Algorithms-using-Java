package util;

/**
 * Pair
 * @author Manjunath Asundi
 */
public class Pair<T, U> {
    private T t1;
    private U u1;

    public Pair(T t1, U u1) {
        this.t1 = t1;
        this.u1 = u1;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((t1 == null) ? 0 : t1.hashCode());
        result = prime * result + ((u1 == null) ? 0 : u1.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pair<T,U> other = (Pair<T,U>) obj;
        if (t1 == null) {
            if (other.t1 != null)
                return false;
        } else if (!t1.equals(other.t1))
            return false;
        if (u1 == null) {
            if (other.u1 != null)
                return false;
        } else if (!u1.equals(other.u1))
            return false;
        return true;
    }
}
