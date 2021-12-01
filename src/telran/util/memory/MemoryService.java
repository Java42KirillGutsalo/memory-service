package telran.util.memory;

public class MemoryService {
public static int getMaxAvailableMemory() {
	
	int maxSize = Integer.MAX_VALUE;
	int left = 0, right = maxSize, middle = 0;
	byte ar[] = null;
	while (left <= right) {
		middle = (int)(((long)right + left) / 2) ;
		try {
			 ar = new byte[middle];
			 ar = null;
			maxSize = middle;
			left = middle + 1;
		} catch (Throwable e) {
			right = middle - 1;
		}
	}
	return maxSize;
}
}
