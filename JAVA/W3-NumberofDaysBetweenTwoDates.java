class Solution {
    public int daysBetweenDates(String date1, String date2) {
        int days1 = convertToDays(date1);
        int days2 = convertToDays(date2);

        return Math.abs(days1 - days2);
    }
    private int convertToDays(String date) {
        String[] parts = date.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int totalDays = 0;
        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }
        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };
        for (int m = 1; m < month; m++) {
            totalDays += daysInMonth[m - 1];

            if (m == 2 && isLeapYear(year)) {
                totalDays++;
            }
        }
        totalDays += day;

        return totalDays;
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}
