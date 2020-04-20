package array;

public class Array {
    private int[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量 capacity 构造 Array
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认数组的容量 capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组元素个数
     *
     * @return int
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 获取数组容量
     *
     * @return int
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在所有元素前添加一个新元素
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在所有元素后添加一个新元素
     *
     * @param e
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 在数组 index 个位置插入元素 e
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full.");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Required index >= 0 and <= size.");
        }

        for (int i = size - 1; i >= index; i --) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size ++;
    }
}
