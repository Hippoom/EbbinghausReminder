
public class EbbinghausReminderRunner {

    public static void main(String[] args) {
        EbbinghausReminder reminder = new EbbinghausReminder("2014-09-13");
        for (String date : reminder.datesToBeReviewed()) {
            System.out.println(date);
        }
    }

}
