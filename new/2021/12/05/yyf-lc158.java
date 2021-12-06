/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private int bufferPointer = 0;
    private int bufferCounter = 0;
    private char[] bufferCacheArr = new char[4];
    public int read(char[] buf, int n) {
        int localPointer = 0;
        while (localPointer < n) {
            if (bufferPointer < bufferCounter) {
                buf[localPointer++] = bufferCacheArr[bufferPointer++];
            } else {
                bufferCounter = read4(bufferCacheArr);
                bufferPointer = 0;
                if (bufferCounter == 0) {
                    break;
                }
            }
        }
        return localPointer;
    }
}
/*
buf: e f 2
buff:
     *
*/
