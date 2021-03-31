import java.util.*;
/**
 * The SecretCode class initialises key, code, and message values and
 * tries to decode a secret message by isolating the characters in key 
 * using the indexes of code 
 */
public class SecretCode
{
    String key;//encrypted message
    String code;//indexes of secret message characters
    String message = "";//decoded message
    
    /**
     * The SecretCode constructor that initialises key and code 
     * @param key the key to initialise
     * @param code the indexes for the secret code
     */
    public SecretCode(String key, String code){
        this.key = key;
        this.code = code; 
    }

    /**
     * The method to detect the indexes indicated in code to parse the
     * key and get the secret message. <br>
     * Secret message is stored in message and returned
     * @return the secret code message
     */
    public String decode()
    {
      Scanner decoder = new Scanner(code);
      while(decoder.hasNextInt()){
          message+=key.charAt(decoder.nextInt());
      }
      return message;
    }
}
