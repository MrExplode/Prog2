package me.sunstorm.prog2.lesson7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.function.Consumer;

public class MyLinkedList<E> {
    @Nullable
    private Node<E> first;
    @Nullable
    private Node<E> last;

    public void add(E element) {
        if (first == null) {
            first = new Node<>(element);
            last = first;
        } else {
            var newNode = new Node<E>(element, last, null);
            last.setNext(newNode);
            last = newNode;
        }
    }

    public void forEach(Consumer<E> consumer) {
        iterator().forEachRemaining(consumer);
    }

    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> currentIteration = first;

            @Override
            public boolean hasNext() {
                if (currentIteration == null) return false;
                return currentIteration.getNext() != null;
            }

            @Override
            public E next() {
                E data = currentIteration.getData();
                currentIteration = currentIteration.getNext();
                return data;
            }
        };
    }
}

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
class Node<E> {
    private final E data;
    @Nullable
    private Node<E> previous;
    @Nullable
    private Node<E> next;
}
