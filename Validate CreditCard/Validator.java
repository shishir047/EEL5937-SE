package io.github.shishir;

public interface Validator {

    void validate(long num);
/*
 If we want to add another type of validator (like a validator for email) then we can do this easily by this Validator interface so
 that this validator would not be dependent only on the credit card.

*/

}
