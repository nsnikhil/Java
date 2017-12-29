package exceptions;

import org.jetbrains.annotations.Contract;

public class InValidPositionException extends RuntimeException {

    private final int mPosition;

    public InValidPositionException(int position) {
        this.mPosition = position;
    }

    @Contract(pure = true)
    public final int getPosition() {
        return mPosition;
    }
}