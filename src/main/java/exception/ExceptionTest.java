package exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {

  private static void checkedException() throws FileNotFoundException {
    throw new FileNotFoundException("");
  }

  private static void unCheckedException() throws NullPointerException {

  }


  public static void main(String[] args) {

    try {
      checkedException();
    } catch (IOException e) {
      e.printStackTrace();
    }

    unCheckedException();
  }
}
