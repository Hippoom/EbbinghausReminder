import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class EbbinghausReminderTest {

    private EbbinghausReminder reminder;

    @Before
    public void givenToday() {
        givenToday(is("2014-04-01"));
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

    private List<String> datesToBeReviewed() {
        return reminder.datesToBeReviewed();
    }

    private void givenToday(String value) {
        this.reminder = new EbbinghausReminder(value);
    }

    private String is(String value) {
        return value;
    }
}
