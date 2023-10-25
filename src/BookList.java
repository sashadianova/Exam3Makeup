import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;


public class BookList {

    public BookList(String bookTitle, String line) {

    }

    public static void main(String[] args) throws IOException {
        List<BookList> books = readBooksFromFile("Nobel.csv");
        FileWriter file = new FileWriter("output.txt");
    }
    private static List<BookList> readBooksFromFile(String fileName) {
        List<BookList> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String bookTitle = null;
            while((line = br.readLine()) != null) {
                if (bookTitle == null) {
                    bookTitle = line;
                } else {
                    books.add(new BookList(bookTitle, line));
                    bookTitle = null;
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
