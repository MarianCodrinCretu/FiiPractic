package com.uaic.bankTrx.miscellaneous;

public class UserNotFoundException extends RuntimeException
{
    public UserNotFoundException(Long id)
    {
        super("Could not found employee with id: " + id);
    }
}
