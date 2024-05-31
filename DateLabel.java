import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateLabel extends JLabel {

    public DateLabel() {
        // Get the current date and format it
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        Date date = new Date();
        String dateString = formatter.format(date);

        // Set the formatted date as the text of the label
        this.setText(dateString);
    }
}
