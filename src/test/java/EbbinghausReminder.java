import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class EbbinghausReminder {

    private DateTime today;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");

    private List<Integer> daysBefore = asList(0, 1, 2, 4, 7, 15);

    @Before
    public void givenToday() {
        given(today(is("2014-04-01")));
    }

    @Test
    public void should_list_dates_to_be_reviewed_containing_today() {
        assertThat(datesToBeReviewed(), hasItem("2014-04-01"));
    }

    @Test
    public void should_list_dates_to_be_reviewed_containing_yesterday() {
        assertThat(datesToBeReviewed(), hasItem("2014-03-31"));
    }

    @Test
    public void should_list_dates_to_be_reviewed_containing_the_day_before_yesterday() {
        assertThat(datesToBeReviewed(), hasItem("2014-03-30"));
    }

    @Test
    public void should_list_dates_to_be_reviewed_containing_4_days_before() {
        assertThat(datesToBeReviewed(), hasItem("2014-03-28"));
    }

    @Test
    public void should_list_dates_to_be_reviewed_containing_7_days_before() {
        assertThat(datesToBeReviewed(), hasItem("2014-03-25"));
    }

    @Test
    public void should_list_dates_to_be_reviewed_containing_15_days_before() {
        assertThat(datesToBeReviewed(), hasItem("2014-03-17"));
    }

    @Test
    public void should_print_all_dates() {
        for (String date: datesToBeReviewed()) {
            System.out.println(date);
        }
    }

    private List<String> datesToBeReviewed() {
        final List<String> dates = new ArrayList<>();
        for (Integer days: this.daysBefore) {
            dates.add(format(today.minusDays(days)));
        }
        return dates;
    }

    private String format(DateTime dateTime) {
        return dateTimeFormatter.print(dateTime);
    }

    private void given(DateTime value) {
        this.today = value;
    }

    private DateTime today(String value) {
        return dateTimeFormatter.parseDateTime(value);
    }

    private String is(String value) {
        return value;
    }
}
