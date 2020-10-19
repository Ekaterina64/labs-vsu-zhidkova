/**
 * Создать класс контейнер, позволяющий хранить произвольное количество объектов.
 * Использование встроенных коллекций запрещено.
 * Контейнер должен позволять добавлять, извлекать, удалять элементы.
 * */

class Container<T> {
    private int size ;
    private Object[] array;

    public Container() {
        this.size = 0;
    }//контэйнер по умолчанию

    public T get_el(int index) {//получить элемент
        checkIndex(index);
        return (T) array[index];
    }

    public int getSize() {
        return size;
    }

    public void set_el(int index, T element) {//установить элемент по индексу
        checkIndex(index);
        this.array[index] = element;
    }

    public void add_el(int index, T t){//добавить el по индексу
        rangeCheckForAdd(index);

        Object[] new_array =  new Object[size+1];

        if (index > 0) System.arraycopy(array, 0, new_array, 0, index);
        new_array[index] = t;
        if (size - index > 0) System.arraycopy(array, index, new_array, index + 1, size - index);

        this.array = new_array;
        this.size += 1;
    }

    public void add_el(T t) {//добавить элемент в конец
        Object[] new_array =  new Object[size+1];

        if (size > 0) System.arraycopy(this.array, 0, new_array, 0, size);
        new_array[size] = t;

        this.array = new_array;
        this.size += 1;
    }

    public boolean remove(T t) {//удалить элемент
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.array[i] == t) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Object[] array = new Object[size - 1];
            System.arraycopy(this.array, 0, array, 0, index);
            if (size - index - 1 > 0) System.arraycopy(this.array, index+1, array, index, size - index - 1);
            this.array = array;
            this.size -= 1;
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            this.array[i] = null;
        }
        this.array = null;
        size = 0;
    }

    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (this.array[i].equals(t)) {
                return true;
            }
        }
        return false;
    }

    public void Show() {
        System.out.print('[');
        for (int i = 0; i < size; i++) {
            System.out.print(this.array[i]);
            if (i + 1 != size) {
                System.out.print(", ");
            }
        }
        System.out.println(']');
    }

    private void rangeCheckForAdd(int index) {//если нет такого индекса для добавки в мас
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkIndex(int index) {//получить ел но нет такого индекса
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
}
