package ru.clevertec.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    private MyList<String> list;

    @BeforeEach
    public void init() {
        list = new MyLinkedList<>();
        list.add("kk");
        list.add("mm");
        list.add("dd");
    }

    @Test
    public void getByIndexShouldAccess() {
        assertEquals("kk", list.get(0));
        assertEquals("mm", list.get(1));
    }

    @Test
    public void getByIndexShouldThrowIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
    }

    @Test
    public void setShouldAccess() {
        list.set(0, "cc");
        assertEquals("cc", list.get(0));
    }

    @Test
    public void setShouldThrowIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, "kk"));
    }

    @Test
    public void addShouldIncreaseSizeBy1() {
        list.add("mm");
        assertEquals(4, list.getSize());
    }

    @Test
    public void addShouldAddElementInLastPosition() {
        list.add("kk");
        assertEquals("kk", list.get(list.getSize() - 1));
    }

    @Test
    public void addByIndexShouldAccess() {
        list.add(0, "oo");
        assertEquals("oo", list.get(0));

        list.add(2, "cc");
        assertEquals("cc", list.get(2));

        list.add(5, "qq");
        assertEquals("qq", list.get(5));

        assertEquals(6, list.getSize());
    }

    @Test
    public void removeByValueFirstElemShouldAccess() {
        list.remove("kk");

        assertEquals(2, list.getSize());
        assertNotEquals("kk", list.get(0));
    }

    @Test
    public void removeByValueLastElemShouldAccess() {
        list.remove("dd");

        assertEquals(2, list.getSize());
    }

    @Test
    public void removeByValueCentralElemShouldAccess() {
        list.remove("mm");

        assertEquals(2, list.getSize());
        assertNotEquals("mm", list.get(1));
    }

    @Test
    public void removeByValueShouldThrowNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> list.remove("gg"));
    }

    @Test
    public void removeByIndexCentralElemShouldAccess() {
        list.remove(1);
        assertEquals(2, list.getSize());
    }

    @Test
    public void removeByIndexFirstElemShouldAccess() {
        list.remove(0);
        assertEquals(2, list.getSize());
    }

    @Test
    public void removeByIndexLastElemShouldAccess() {
        list.remove(2);
        assertEquals(2, list.getSize());
    }

    @Test
    public void toStringShouldAccess() {
        String result = "0)kk 1)mm 2)dd ";
        assertEquals(result,list.toString());
    }
}