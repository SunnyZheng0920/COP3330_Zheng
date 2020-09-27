import java.util.Scanner;
public class Application {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // Promotes User for input
        System.out.println("Please enter a 4 digits number to encrypt: ");

        // Store User input into a String variable
        String userInput = input.next();

        Encrypter encrypt1 = new Encrypter();
        String encryptedValue = encrypt1.encrypt(userInput);
        System.out.println(encryptedValue);

        // Promotes User for input
        System.out.println("Please enter a 4 digits number to decrypt: ");

        String decryptNum = input.next();

        Decrypter decrypt1 = new Decrypter();
        String decryptedValue = decrypt1.decrypt(decryptNum);
        System.out.println(decryptedValue);

    }
}
