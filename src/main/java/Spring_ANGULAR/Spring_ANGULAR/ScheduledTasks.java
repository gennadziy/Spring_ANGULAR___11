package Spring_ANGULAR.Spring_ANGULAR;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

@Slf4j
@Component
public class ScheduledTasks{
    @Scheduled(fixedDelay = 1200000)
    public void getQuery() throws IOException {


            //get URL content
           URL url = new URL("https://angular6.herokuapp.com/springboot-crud-rest/api/v1/planets");
          URL url1 = new URL("https://app-gennadziy.herokuapp.com/");
        URLConnection conn = url.openConnection();
        URLConnection conn1 = url1.openConnection();
        BufferedReader br = new BufferedReader(
                    new InputStreamReader (conn.getInputStream()));
        BufferedReader br1 = new BufferedReader(
                new InputStreamReader (conn1.getInputStream()));
            String inputLine;
            String fileName = "C:/1.txt";
            File file = new File(fileName);

            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            while ((inputLine = br.readLine()) != null) {
                bw.write(inputLine);
            }

            bw.close();
            br.close();
            log.info("DONE!!!" + new Date ());

}}