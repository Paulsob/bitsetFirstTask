import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class bitset<T> {
    private int length;
    //создание массива длины length

    private final ArrayList<T> numbers = new ArrayList<>(length);

    public bitset(int len, ArrayList<T> arrayList) {
        // реализация инициализации этого массива
        this.length = len;
        this.numbers.addAll(arrayList);
    }

    public ArrayList<T> getMas() {
        return this.numbers;
    }

    public Integer getLen() {
        return length;
    }

    public void printing() {
        System.out.println(this.numbers);
        System.out.println(this.length);
    }

    public bitset<T> unification(bitset<T> bNew) {
        // реализация объединения двух множеств
        ArrayList<T> arrayList = new ArrayList<>();
        bitset<T> b3 = new bitset<>(0, arrayList);
        b3.numbers.addAll(this.numbers);
        b3.numbers.addAll(bNew.numbers);
        b3.length = this.length + bNew.length;
        return b3;
    }

    public bitset<T> intersection(bitset<T> bNew) {
        // реализация пересечения двух множеств
        ArrayList<T> arrayList = new ArrayList<>();
        int count = 0;
        bitset<T> b3 = new bitset<>(0, arrayList);
        for (int i = 0; i < this.length; ++i) {
            for (int j = 0; j < bNew.length; ++j) {
                if (Objects.equals(this.numbers.get(i), bNew.numbers.get(j))) {
                    count++;
                    b3.numbers.add(this.numbers.get(i));
                }
            }
        }
        b3.length = count;
        return b3;
    }

    public bitset<T> addingElement(T element) {
        // реализация добавления заданного элемента
        ArrayList<T> arrayList = new ArrayList<>();
        bitset<T> b3 = new bitset<>(0, arrayList);
        b3.numbers.addAll(this.numbers);
        b3.numbers.add(element);
        b3.length = this.length + 1;
        return b3;
    }

    public bitset<T> addingArray(Collection<? extends T> arrayList) {
        // реализация добавления заданного массива элементов
        ArrayList<T> NewArrayList = new ArrayList<>();
        bitset<T> b3 = new bitset<>(0, NewArrayList);
        b3.numbers.addAll(this.numbers);
        b3.numbers.addAll(arrayList);
        b3.length = this.length + arrayList.size();
        return b3;
    }

    public String belonging(bitset<T> bNew, T element) {
        // реализация проверки принадлежности элемента массиву
        if (bNew.numbers.contains(element))
            return "Element " + element + " belongs to the bitset b2";
        return "Element " + element + " does not belongs to the bitset b2";
    }

    public void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        bitset<Integer> b1 = new bitset<>(4, arrayList1);
        bitset<Integer> b2 = new bitset<>(9, arrayList2);
        bitset<Integer> b3 = new bitset<>(0, arrayList3);
        ArrayList<Integer> arrayList = new ArrayList<>();
        b3 = b1.unification(b2);
        b3.printing();
        b3 = b1.intersection(b2);
        b3.printing();
        b3 = b1.addingElement(4);
        b3.printing();
        b3 = b1.addingArray(arrayList);
        b3.printing();
        String str = b1.belonging(b2, 5);
        System.out.println(str);
    }
}