import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class EbbinghausReminder {
    private final DateTime today;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
    private final List<Integer> daysBefore = asList(0, 1, 2, 4, 7, 15);

    public EbbinghausReminder(String today) {
        this.today = dateTimeFormatter.parseDateTime(today);
    }

    public List<String> datesToBeReviewed() {
        final List<String> dates = new ArrayList<>();
        for (Integer days : this.daysBefore) {
            dates.add(format(today.minusDays(days)));
        }
        return dates;
    }

    private String format(DateTime dateTime) {
        return dateTimeFormatter.print(dateTime);
    }
}