import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    //Kiểm tra phần tử có tồn tại trong elements hay ko
    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Err! Index: " + index + ", Size: " + size);
        }
    }

    //Thêm một phần tử tại vị trí index
    public void add(int index, E element) {
        checkIndex(index);
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    //Xóa một phần tử tại vị trí index
    public E remove(int index) {
        checkIndex(index);
        E e = (E) elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return e;
    }

    //Trả về true nếu danh sách có chứa phần tử element
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    //Trả về vị trí index của phần tử phù hợp đầu tiên trong danh sách, ko khớp trả về -1
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    //Tăng kích thước mảng chứa các phần tử lên 1
    public void ensureCapacity() {
        if (size == elements.length) {
            int newSize = elements.length + 1;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    //Trả về phần tử vừa ở vị trí thứ index trong danh sách.
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    //Xóa danh sách
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
