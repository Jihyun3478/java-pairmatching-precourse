package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewNameParser {
    private static final String FRONTEND_CREW_PATH = "src/main/resources/frontend-crew.md";
    private static final String BACKEND_CREW_PATH = "src/main/resources/backend-crew.md";

    public static List<String> getNames(Course course) {
        List<String> names = new ArrayList<>();
        FileReader file = null;
        try {
            if(course.equals(Course.BACKEND)) {
                file = new FileReader(BACKEND_CREW_PATH);
            }
            if(course.equals(Course.FRONTEND)) {
                file = new FileReader(FRONTEND_CREW_PATH);
            }
            BufferedReader bufferedReader = new BufferedReader(file);

            String data = "";
            while ((data = bufferedReader.readLine()) != null) {
                names.add(data);
            }
            file.close();

        } catch (IOException e) {
            throw new IllegalStateException();
        }
        return names;
    }
}
