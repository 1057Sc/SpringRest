package org.sc.practice.javaStatement;

/**
 * Created by Sc on 2019/3/14.
 *
 * @Description:
 */
public class StringSwitchDemoDeCompile {
    public StringSwitchDemoDeCompile() {
    }

    public static int getMonthNumber(String month) {
        int monthNumber = 0;
        if(month == null) {
            return monthNumber;
        } else {
            String var2 = month.toLowerCase();
            byte var3 = -1;
            switch(var2.hashCode()) {
                case -2029849391:
                    if(var2.equals("september")) {
                        var3 = 8;
                    }
                    break;
                case -1826660246:
                    if(var2.equals("january")) {
                        var3 = 0;
                    }
                    break;
                case -1621487904:
                    if(var2.equals("october")) {
                        var3 = 9;
                    }
                    break;
                case -1406703101:
                    if(var2.equals("august")) {
                        var3 = 7;
                    }
                    break;
                case -263893086:
                    if(var2.equals("february")) {
                        var3 = 1;
                    }
                    break;
                case 107877:
                    if(var2.equals("may")) {
                        var3 = 4;
                    }
                    break;
                case 3273752:
                    if(var2.equals("july")) {
                        var3 = 6;
                    }
                    break;
                case 3273794:
                    if(var2.equals("june")) {
                        var3 = 5;
                    }
                    break;
                case 93031046:
                    if(var2.equals("april")) {
                        var3 = 3;
                    }
                    break;
                case 103666243:
                    if(var2.equals("march")) {
                        var3 = 2;
                    }
                    break;
                case 561839141:
                    if(var2.equals("december")) {
                        var3 = 11;
                    }
                    break;
                case 1639129394:
                    if(var2.equals("november")) {
                        var3 = 10;
                    }
            }

            switch(var3) {
                case 0:
                    monthNumber = 1;
                    break;
                case 1:
                    monthNumber = 2;
                    break;
                case 2:
                    monthNumber = 3;
                    break;
                case 3:
                    monthNumber = 4;
                    break;
                case 4:
                    monthNumber = 5;
                    break;
                case 5:
                    monthNumber = 6;
                    break;
                case 6:
                    monthNumber = 7;
                    break;
                case 7:
                    monthNumber = 8;
                    break;
                case 8:
                    monthNumber = 9;
                    break;
                case 9:
                    monthNumber = 10;
                    break;
                case 10:
                    monthNumber = 11;
                    break;
                case 11:
                    monthNumber = 12;
                    break;
                default:
                    monthNumber = 0;
            }

            return monthNumber;
        }
    }

    public static void main(String[] args) {
        String month = "August";
        int returnedMonthNumber = getMonthNumber(month);
        if(returnedMonthNumber == 0) {
            System.out.println("Invalid month");
        } else {
            System.out.println(returnedMonthNumber);
        }

    }
}
