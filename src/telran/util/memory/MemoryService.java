package telran.util.memory;

public class MemoryService {
public static int getMaxAvailableMemory() {
	long maxMemory = Runtime.getRuntime().maxMemory();
	int maxSize = maxMemory > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) maxMemory;
	
	int left = 0;
	int right = maxSize;
	int middle = 0;
	int maxAvailableMemory = 0;
	byte ar[] = null;
	
	while (left <= right) {
		middle = (int)(((long)right + left) / 2);
		try {
			ar = new byte[middle];
			maxAvailableMemory = middle;
			left = middle++;
			ar = null;
		} catch (OutOfMemoryError e) {
					right = middle--;
					}
		}
	return maxAvailableMemory;
}
}
