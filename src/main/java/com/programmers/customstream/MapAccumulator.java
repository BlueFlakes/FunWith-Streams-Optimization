package com.programmers.customstream;

import java.util.function.Function;
import java.util.stream.Stream;

public class MapAccumulator<A, B> {
    private Function<? super A, ? extends B> mapper;
    private Stream<A> stream;

    public MapAccumulator(Function<? super A, ? extends B> mapper, Stream<A> stream) {
        this.mapper = mapper;
        this.stream = stream;
    }

    public <R> MapAccumulator<A, R> extendMap(Function<? super B, ? extends R> nextMapper) {
        Function<? super A, ? extends B> current = this.mapper;
        Function<? super A, ? extends R> f = current.andThen(nextMapper);
        return new MapAccumulator<>(f, this.stream);
    }

    public Stream<B> execute() {
        return this.stream.map(this.mapper);
    }
}
