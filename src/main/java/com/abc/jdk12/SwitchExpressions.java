package com.abc.jdk12;

public class SwitchExpressions {

    // switch 新标签 ->
    public static String getTypeOfDayWithSwitchStatement1(String dayOfWeekArg) {
        String typeOfDay;
        switch (dayOfWeekArg) {
            case "Monday" -> typeOfDay = "Start of work week";
            case "Tuesday", "Wednesday", "Thursday" -> typeOfDay = "Midweek";
            case "Friday" -> typeOfDay = "End of work week";
            case "Saturday", "Sunday" -> typeOfDay = "Weekend";
            default -> throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
        }
        return typeOfDay;
    }

    // switch 做表达式
    public static String getTypeOfDayWithSwitchStatement2(String dayOfWeekArg) {
        return switch (dayOfWeekArg) {
            case "Monday" -> "Start of work week";
            case "Tuesday", "Wednesday", "Thursday" -> "Midweek";
            case "Friday" -> "End of work week";
            case "Saturday", "Sunday" -> "Weekend";
            default -> throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
        };
    }

    public static void main(String[] args) {
        System.out.println(getTypeOfDayWithSwitchStatement2("Monday"));
    }
}
