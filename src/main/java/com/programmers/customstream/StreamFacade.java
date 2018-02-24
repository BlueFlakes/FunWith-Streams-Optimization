package com.programmers.customstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StreamFacade<T> implements Stream<T> {
    private Stream<T> stream;

    private StreamFacade(Stream<T> stream) {
        this.stream = stream;
    }

    public static <U> StreamFacade<U> of(Collection<U> items) {
        return new StreamFacade<>(items.stream());
    }

    public static <U> StreamFacade<U> of(U... items) {
        return new StreamFacade<>(Stream.of(items));
    }

    public <R> MapAccumulator<T, R> magicMap(Function<? super T, ? extends R> mapper) {
        return new MapAccumulator<>(mapper, this.stream);
    }

    @Override
    public Stream<T> filter(Predicate<? super T> predicate) {
        return this.stream.filter(predicate);
    }

    @Override
    public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
        return this.stream.map(mapper);
    }

    @Override
    public IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return this.stream.mapToInt(mapper);
    }

    @Override
    public LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return this.stream.mapToLong(mapper);
    }

    @Override
    public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return this.stream.mapToDouble(mapper);
    }

    @Override
    public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return this.stream.flatMap(mapper);
    }

    @Override
    public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return this.stream.flatMapToInt(mapper);
    }

    @Override
    public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return this.stream.flatMapToLong(mapper);
    }

    @Override
    public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return this.stream.flatMapToDouble(mapper);
    }

    @Override
    public Stream<T> distinct( ) {
        return this.stream.distinct();
    }

    @Override
    public Stream<T> sorted( ) {
        return this.stream.sorted();
    }

    @Override
    public Stream<T> sorted(Comparator<? super T> comparator) {
        return this.stream.sorted(comparator);
    }

    @Override
    public Stream<T> peek(Consumer<? super T> action) {
        return this.stream.peek(action);
    }

    @Override
    public Stream<T> limit(long maxSize) {
        return this.stream.limit(maxSize);
    }

    @Override
    public Stream<T> skip(long n) {
        return this.stream.skip(n);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        this.stream.forEach(action);
    }

    @Override
    public void forEachOrdered(Consumer<? super T> action) {
        this.stream.forEachOrdered(action);
    }

    @Override
    public Object[] toArray( ) {
        return this.stream.toArray();
    }

    @Override
    public <A> A[] toArray(IntFunction<A[]> generator) {
        return this.stream.toArray(generator);
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return this.stream.reduce(identity, accumulator);
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return this.stream.reduce(accumulator);
    }

    @Override
    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return this.stream.reduce(identity, accumulator, combiner);
    }

    @Override
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return this.stream.collect(supplier, accumulator, combiner);
    }

    @Override
    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return this.stream.collect(collector);
    }

    @Override
    public Optional<T> min(Comparator<? super T> comparator) {
        return this.stream.min(comparator);
    }

    @Override
    public Optional<T> max(Comparator<? super T> comparator) {
        return this.stream.max(comparator);
    }

    @Override
    public long count( ) {
        return this.stream.count();
    }

    @Override
    public boolean anyMatch(Predicate<? super T> predicate) {
        return this.stream.anyMatch(predicate);
    }

    @Override
    public boolean allMatch(Predicate<? super T> predicate) {
        return this.stream.allMatch(predicate);
    }

    @Override
    public boolean noneMatch(Predicate<? super T> predicate) {
        return this.stream.noneMatch(predicate);
    }

    @Override
    public Optional<T> findFirst( ) {
        return this.stream.findFirst();
    }

    @Override
    public Optional<T> findAny( ) {
        return this.stream.findAny();
    }

    @Override
    public Iterator<T> iterator( ) {
        return this.stream.iterator();
    }

    @Override
    public Spliterator<T> spliterator( ) {
        return this.stream.spliterator();
    }

    @Override
    public boolean isParallel( ) {
        return this.stream.isParallel();
    }

    @Override
    public Stream<T> sequential( ) {
        return this.stream.sequential();
    }

    @Override
    public Stream<T> parallel( ) {
        return this.stream.parallel();
    }

    @Override
    public Stream<T> unordered( ) {
        return this.stream.unordered();
    }

    @Override
    public Stream<T> onClose(Runnable closeHandler) {
        return this.stream.onClose(closeHandler);
    }

    @Override
    public void close( ) {
        this.stream.close();
    }
}
