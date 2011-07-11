package system;

/**
 *
 * ���Ͷ�̬����
 */
public class ArrayList {

    private int[] data = null;//����
    private int increment = 10;//���洢�ռ䲻��ʱһ����׷�ӵĿռ���
    private static final int DEFAULTLENGHT = 10;//Ĭ�ϵĶ�̬����ĳ�ʼ��С
    private int size = 0;//��̬�����е�ǰԪ�ظ���

    /**
     * ����һ��Ĭ�ϳ�ʼ��С�Ķ�̬����
     */
    public ArrayList() {
        data = new int[DEFAULTLENGHT];
        clear();
    }

    /**
     * ����һ��ָ����ʼ��С�Ķ�̬����
     * @param lenght ָ���ĳ�ʼ��С
     */
    public ArrayList(int lenght) {
        data = new int[lenght];
        clear();
    }

    /**
     * ����һ��ָ����ʼ��С��ָ�������Ķ�̬����
     * @param lenght ָ���ĳ�ʼ��С
     * @param increment ָ��������
     */
    public ArrayList(int lenght, int increment) {
        data = new int[lenght];
        this.increment = increment;
        clear();
    }

    public int size() {
        return size;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    public int getIncrement() {
        return increment;
    }

    public int capacity() {
        return data.length;
    }

    public int[] toArray() {
        int[] array = new int[size];
        System.arraycopy(data, 0, array, 0, size);
        return array;
    }

    /**
     * ���ָ��������
     * @param index
     * @throws Exception
     */
    public synchronized boolean add(int index) {
        if (has(index)) {
            //���һ���Ѿ����ڵ������׳�һ���쳣
            return false;
        } else {
            //����������ڴ����������
            //��һ�������ռ��Ƿ��㹻��������׷��
            if (size == data.length) {
                int[] array = new int[size + increment];
                System.arraycopy(data, 0, array, 0, size);
                data = array;

            }
            //�ڶ����������������size��1
            data[size] = index;
            size++;
            return true;
        }
    }

    /**
     * ɾ��ָ��������
     * @param index
     */
    public synchronized boolean remove(int index) {
        if (!has(index)) {
            return false;
        } else {
            //��һ���ҵ�Ҫɾ�����������±�
            int i = 0;
            for (i = 0; i < size; i++) {
                if (data[i] == index) {
                    break;
                }
            }
            //(i+1)----(size-1)��Ԫ��ǰ��
            for (int j = i + 1; j < size; j++) {
                data[j - 1] = data[j];
            }
            //���size-1λ�õ�Ԫ��
            data[size - 1] = -1;
            //size��1
            size--;
            return true;
        }
    }

    public boolean has(int index) {
        boolean judge = false;
        for (int i = 0; i < size; i++) {
            if (data[i] == index) {
                judge = true;
                break;
            }
        }
        return judge;
    }

    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = -1;
        }
        size = 0;
    }

    public int get(int index) {
        if (index < 0 | index > data.length) {
            return -1;
        }
        return data[index];
    }
}
