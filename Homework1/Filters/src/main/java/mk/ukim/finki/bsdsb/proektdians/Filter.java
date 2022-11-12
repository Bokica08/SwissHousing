package mk.ukim.finki.bsdsb.proektdians;

public interface Filter<T> {
    T execute(T input);
}
