package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main extends Application {
    private static Connection conn;
    private static final String table = "cr6";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("School statistics of Teachers");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static ArrayList<Teacher> getTeachers(){
        ArrayList<Teacher> teachers = new ArrayList<>();
        try {
            PreparedStatement teacherList = conn.prepareStatement("SELECT * FROM teacher" );
            System.out.println("1");
            ResultSet set = teacherList.executeQuery();
            System.out.println("2");
            while (set.next()) {
                teachers.add(new Teacher(set.getInt("idteacher"), set.getString("name"), set.getString("surname"), set.getString("email")));
            }
        } catch (Exception e){
            System.out.println("Problem retrieving data");
            System.out.println(e);
        }
        return teachers;
    }

    public static ArrayList<String> getClasses(int teacherID){
        ArrayList<String> classes = new ArrayList<>();
        try {
            PreparedStatement teacherList = conn.prepareStatement("SELECT * FROM class inner join teacher_class on class.idclass = teacher_class.classID && teacher_class.teacherID = " + teacherID);
            System.out.println("1");
            ResultSet set = teacherList.executeQuery();
            System.out.println("2");
            while (set.next()) {
                classes.add(set.getString("class.name"));
            }
        } catch (Exception e){
            System.out.println("Problem retrieving data");
            System.out.println(e);
        }
        return classes;
    }


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cr6" +
                            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "45456");
        } catch (Exception e){
            System.out.println("Problem connecting to database");
        }
        launch(args);
    }
}
