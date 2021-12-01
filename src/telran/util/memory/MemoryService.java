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
			// V.R. The following has to be here
			// left = middle + 1;
			left = middle++;
			ar = null;
		} catch (OutOfMemoryError e) {
			// V.R. The following has to be here
			// right = middle - 1;
			// It isn't the same
			right = middle--;
		}
	}
	return maxAvailableMemory;
}
}
