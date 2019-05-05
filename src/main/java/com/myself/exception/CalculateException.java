package com.myself.exception;

/**
 * @Author: Wang Yu Qiang
 * @Description:
 * @Date: Create in 16:09 2019/4/29
 */
public class CalculateException extends RuntimeException {
    private static final long serialVersionUID = 5162710183389028792L;

    /**
     * Constructs a {@code CalculateException} with no detail message.
     */
    public CalculateException() {
        super();
    }

    /**
     * Constructs a {@code CalculateException} with the specified detail
     * message.
     *
     * @param message
     *            the detail message.
     */
    public CalculateException(String message) {
        super(message);
    }

    /**
     * Constructs a {@code CalculateException} with the specified detail
     * message & cause
     *
     * @param message
     * @param cause
     */
    public CalculateException(String message, Throwable cause) {
        super(message, cause);
    }
}
