package com.gmail.runkevich8.domain.exception;



public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
