package Spring_ANGULAR.Spring_ANGULAR.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.sql.DriverManager.println;


public class test {
    public static void main ( String[] args ) throws IOException, ClassNotFoundException {
       List<Integer> list = new ArrayList<> ();
       list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        for(Integer s: list){
            System.out.println (s );
        }
    }
}
