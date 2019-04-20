
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileRead {
    //Read the first word in the file :"Word.txt"
    // The Path must be in the main project route otherwise insert specific route.
    protected String ReadFromFile() throws IOException {
        Scanner sc =
                new Scanner(Paths.get("Words.txt"));
    //"D:\\Dropbox\\OpenUN\\Java_Programing_20554\\Mamans_2019b\\Maman13\\Q1\\src\\Words.txt
        return sc.nextLine();

    }

}
