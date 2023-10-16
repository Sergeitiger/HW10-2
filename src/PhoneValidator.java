import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {

    public static void main(String[] args) {
        String fileName = "file.txt"; // Замініть це на шлях до вашого файлу

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Регулярний вираз для першого формату (xxx) xxx-xxxx
        String regex1 = "\\(\\d{3}\\) \\d{3}-\\d{4}";

        // Регулярний вираз для другого формату xxx-xxx-xxxx
        String regex2 = "\\d{3}-\\d{3}-\\d{4}";

        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);

        Matcher matcher1 = pattern1.matcher(phoneNumber);
        Matcher matcher2 = pattern2.matcher(phoneNumber);

        return matcher1.matches() || matcher2.matches();
    }
}
