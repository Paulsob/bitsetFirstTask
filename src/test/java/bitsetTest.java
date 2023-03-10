import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class bitsetTest {

    @Test
    void unification() {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("2");
        arrayList1.add("23");
        bitset<String> b1 = new bitset<>(2, arrayList1);

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("1");
        arrayList2.add("11");
        bitset<String> bNew = new bitset<>(2, arrayList2);

        bitset<String> actual = b1.unification(bNew);
        ArrayList<String> numbers = new ArrayList<>(4);
        String[] list = {"2", "23", "1", "11"};
        for (int i = 0; i < 4; i++) {
            numbers.add(list[i]);
        }
        int length = 4;
        assertEquals(length, actual.getLen());
        assertEquals(numbers, actual.getMas());
    }

    @Test
    void intersection() {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(2);
        arrayList1.add(23);
        bitset<Integer> b1 = new bitset<>(2, arrayList1);

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        arrayList2.add(23);
        bitset<Integer> bNew = new bitset<>(2, arrayList2);

        bitset<Integer> actual = b1.intersection(bNew);
        ArrayList<Integer> numbers = new ArrayList<>(4);
        numbers.add(23);
        int length = 1;
        assertEquals(length, actual.getLen());
        assertEquals(numbers, actual.getMas());
    }

    @Test
    void addingElement() {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(2);
        arrayList1.add(23);
        bitset<Integer> b1 = new bitset<>(2, arrayList1);

        int element = 5;

        bitset<Integer> actual = b1.addingElement(element);
        ArrayList<Integer> numbers = new ArrayList<>();
        int[] list = {2, 23, 5};
        for (int i = 0; i < 3; i++) {
            numbers.add(list[i]);
        }
        int length = 3;
        assertEquals(length, actual.getLen());
        assertEquals(numbers, actual.getMas());
    }

    @Test
    void addingArray() {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(2);
        arrayList1.add(23);
        bitset<Integer> b1 = new bitset<>(4, arrayList1);

        int[] array = {4, 5, 6, 7, 8};
        ArrayList<Integer> numbers = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            numbers.add(array[i]);
        }
        int[] expected = {2, 23, 4, 5, 6, 7, 8};
        ArrayList<Integer> expect = new ArrayList<>(9);
        for (int j = 0; j < 7; j++) {
            expect.add(expected[j]);
        }
        bitset<Integer> actual = b1.addingArray(numbers);
        int length = 9;
        assertEquals(length, actual.getLen());
        assertEquals(expect, actual.getMas());
    }

    @Test
    void belonging() {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(2);
        arrayList1.add(23);
        bitset<Integer> bNew = new bitset<>(2, arrayList1);

        int element = 5;
        String actual = "Element " + element + " does not belongs to the bitset b2";
        String expected = bNew.belonging(bNew, element);
        assertEquals(expected, actual);
    }
}