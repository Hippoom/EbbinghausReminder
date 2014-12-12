public class EbbinghausReminderRunner {

    public static void main(String[] args) {
        EbbinghausReminder reminder = new EbbinghausReminder("2014-12-12");
        for (String date : reminder.datesToBeReviewed()) {
            System.out.println(date);
        }
        System.out.println("The old ones:");
        System.out.println(reminder.randomDatesToBeReviewedAfter("2014-08-22"));
    }

}
