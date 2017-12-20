package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenericUtil {

    public static final String INTEGER_INPUT_MESSAGE = "Enter the no";
    public static final String INTEGER_POSITION_MESSAGE = "Enter the position";
    public static final String STRING_INPUT_MESSAGE = "Enter the string";

    private static BufferedReader mBufferedReader;

    /**
     * @return buffered reader
     */
    private static BufferedReader getBufferedReader() {
        if (mBufferedReader == null) mBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return mBufferedReader;
    }

    /**
     * @return output stream
     * @throws IOException input/output exception
     */
    public static int takeIntegerInput() throws IOException {
        return Integer.parseInt(takeStringInput());
    }

    /**
     * @return output stream
     * @throws IOException input/output exception
     */
    public static String takeStringInput() throws IOException {
        return getBufferedReader().readLine();
    }

}
