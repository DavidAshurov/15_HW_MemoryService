package telran.memory.utils;

public class MemoryService {
    public static int getMaxAvailableMemory() {
        int maxSize = Integer.MAX_VALUE;
        int maxSizePlusOne = 0;
        int step = maxSize / 2;
        boolean flag = false;
        while (!flag) {
            try {
                int[] arr = new int[maxSize];
                maxSizePlusOne = maxSize + 1;
                arr = new int[maxSizePlusOne];
                maxSize += step;
            } catch (OutOfMemoryError err) {
                if (maxSizePlusOne == maxSize + 1) {
                    flag = true;
                    continue;
                }
                maxSize -= step;
            } finally {
                step /= 2;
            }
        }
        System.out.println(maxSize);
        return maxSize;
    }
}
