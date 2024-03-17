package com.shopping.cart.main.app.exception;

public class InvalidItemException extends RuntimeException{

  public InvalidItemException(String message) {
    super(message);
  }
}
