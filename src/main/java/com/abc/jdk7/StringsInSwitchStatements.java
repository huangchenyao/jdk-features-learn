package com.abc.jdk7;

/*
 * String用于switch
 * 在Java 7中，switch语句中支持使用String对象
 * 在Java 7之前，switch只能使用整型，或者其他可以转换为整型的数值类型(byte, short, long, char, enum)
 */
public class StringsInSwitchStatements {
    /*
     * switch语句将表达式中的String与每个case的String进行比较，使用的是String.equals()方法，因此switch中使用String是区分大小写的
     */
    public String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
        String typeOfDay;
        switch (dayOfWeekArg) {
            case "Monday":
                typeOfDay = "Start of work week";
                break;
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                typeOfDay = "Midweek";
                break;
            case "Friday":
                typeOfDay = "End of work week";
                break;
            case "Saturday":
            case "Sunday":
                typeOfDay = "Weekend";
                break;
            default:
                throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
        }
        return typeOfDay;
    }
}
