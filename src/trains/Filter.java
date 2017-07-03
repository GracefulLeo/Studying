package trains;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class Filter {
    private Filter() {
    }

    static Predicate<Train> byId(int id) {
        return train -> train.getId() == id;
    }

    static Predicate<Train> fromCity(String city) {
        return train -> train.getFrom().equals(city);
    }

    static Predicate<Train> toCity(String city) {
        return train -> train.getTo().equals(city);
    }

    static Predicate<Train> afterDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        return train -> {
            boolean rez = false;

            try {
                rez = sdf.parse(train.getDate()).after(sdf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return rez;
        };
    }

    static Predicate<Train> beforeDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        return train -> {
            boolean rez = false;

            try {
                rez = sdf.parse(train.getDate()).before(sdf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return rez;
        };
    }

    static Predicate<Train> dateRange(String fromDate, String toDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        return train -> {
            boolean rez = false;

            try {
                rez = (
                        sdf.parse(train.getDate()).equals(sdf.parse(fromDate)) || sdf.parse(train.getDate()).after(sdf.parse(fromDate))
                ) && (
                        sdf.parse(train.getDate()).equals(sdf.parse(toDate)) || sdf.parse(train.getDate()).before(sdf.parse(toDate))
                );
            } catch (ParseException e) {
                e.getMessage();
            }

            return rez;
        };
    }

    static Predicate<Train> afterTime(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        return train -> {
            boolean rez = false;

            try {
                rez = sdf.parse(train.getTime()).after(sdf.parse(time));
            } catch (ParseException e) {
                e.getMessage();
            }

            return rez;
        };
    }

    static Predicate<Train> beforeTime(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        return train -> {
            boolean rez = false;

            try {
                rez = sdf.parse(train.getTime()).before(sdf.parse(time));
            } catch (ParseException e) {
                e.getMessage();
            }

            return rez;
        };
    }

    static Predicate<Train> timeRange(String fromTime, String toTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        return train -> {
            boolean rez = false;

            try {
                rez = (
                        sdf.parse(train.getTime()).equals(sdf.parse(fromTime)) || sdf.parse(train.getTime()).after(sdf.parse(fromTime))
                ) && (
                        sdf.parse(train.getTime()).equals(sdf.parse(toTime)) || sdf.parse(train.getTime()).before(sdf.parse(toTime))
                );
            } catch (ParseException e) {
                e.getMessage();
            }

            return rez;
        };
    }
}
