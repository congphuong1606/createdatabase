import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bien on 7/12/2017.
 */
public class Main {

    static Connection c = null;
    private static ArrayList<Lesson> lessons;


    public static void readFile() {

        try {
            for (Lesson lesson : lessons) {
                PreparedStatement statement = null;
                statement = c.prepareStatement("INSERT INTO `Lesson`(`NAME`,`PATH`,`CHAPTER`) VALUES(?,?,?)");
                statement.setString(1, lesson.getName());
                statement.setString(2, lesson.getPath());
                statement.setString(3, lesson.getChapter());
                statement.executeUpdate();
                statement.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void createLessons() {
        lessons = new ArrayList<>();
        lessons.add(new Lesson(1, "fvhjfb", "f", ""));
    }

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Demo.sqlite");
            System.out.println("Opened database successfully");
            createLessons();
            readFile();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
