package team.ytk.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Stream {

    public static class Node<T> {

        public long index;
        public T value;
        public long size;
        public List<T> list;

        public Node(long index, T value, long size, List<T> list) {
            this.index = index;
            this.value = value;
            this.size = size;
            this.list = list;
        }
    }

    public static <T> java.util.stream.Stream<Node<T>> from(java.util.stream.Stream<T> rawStream) {
        List<T> list = rawStream.collect(Collectors.toList());
        long length = list.size();
        return LongStream
            .range(0, length)
            .mapToObj(index -> new Node<T>(index, list.get((int) index), length, list));
    }
}
