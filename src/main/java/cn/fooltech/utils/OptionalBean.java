package cn.fooltech.utils;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class OptionalBean<T> {
    private static OptionalBean<?> EMPTY = new OptionalBean<>();
    private final T value;

    private OptionalBean() {
        this.value = null;
    }

    private OptionalBean(T value) {
        this.value = Objects.requireNonNull(value);
    }

    public static <T> OptionalBean<T> of(T value) {
        return new OptionalBean<>(value);
    }

    public static <T> OptionalBean<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }

    public <R> OptionalBean<R> getBean(Function<? super T, ? extends R> fn) {
        return Objects.isNull(value) ? OptionalBean.empty() : OptionalBean.ofNullable(fn.apply(value));
    }

    public T orElse(T other) {
        return value != null ? value : other;
    }

    public T orElseGet(Supplier<? extends T> other) {
        return value != null ? value : other.get();
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> excetionSupplier) throws X {
        if (value != null) {
            return value;
        } else {
            throw excetionSupplier.get();
        }
    }

    public boolean isPresent() {
        return value != null;
    }

    public void ifPresent(Consumer<? super T> consumer) {
        if (value != null) {
            consumer.accept(value);
        }
    }

    public static <T> OptionalBean<T> empty() {
        OptionalBean<T> none = (OptionalBean<T>) EMPTY;
        return none;
    }

}
