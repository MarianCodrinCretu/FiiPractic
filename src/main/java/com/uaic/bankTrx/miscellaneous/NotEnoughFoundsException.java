package com.uaic.bankTrx.miscellaneous;

public class NotEnoughFoundsException extends RuntimeException
{
    public NotEnoughFoundsException(Double amount) {
        super("Not Enough Founds Exception " + amount);
    }
}
