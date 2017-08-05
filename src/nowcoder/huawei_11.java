package nowcoder;

import java.util.Scanner;

/**
 * Created by lpeiz on 2017/4/21.
 */
public class huawei_11 {


        private static int ans = 0;
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String time = in.nextLine();
            String[] times = time.split("-");
            if (!isValid(times)) {
                System.out.println("invalid input");
                return;
            }
            int year = Integer.parseInt(times[0]);
            int month = Integer.parseInt(times[1]);
            int day = Integer.parseInt(times[2]);
            int ans = 0;
            for (int i = 1; i < month; i++) {
                ans += getDays(year, i);
            }
            ans += day;

            System.out.printf("%s-%s-%s is the No.%d day of %s.\n", times[0], times[1], times[2], ans, times[0]);
//            System.out.println();
        }
        public static boolean isValid(String[] times){
            for(int i = 0; i < times.length; i++){
                char[] chars = times[i].toCharArray();
                for(int j = 0; j < chars.length; j++){
//                if(chars[0] == '0') return false;
                    if(chars[j] > '9' || chars[j] < '0') return false;
                }
            }
            int year = Integer.parseInt(times[0]);
            int month= Integer.parseInt(times[1]);
            int day = Integer.parseInt(times[2]);
            if(year > 10000) return false;
            if(month > 12 || month < 1) return false;
            if(day > getDays(year,month)) return false;
            return true;
        }
        public static boolean isLeapYear(int year){
            if(year % 100 == 0){
                return year % 400 == 0;
            }
            else{
                return year % 4 == 0;
            }
        }
        public static int getDays(int year, int month){
            if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                return 31;
            else{
                if(month == 2){
                    if(isLeapYear(year))
                        return 29;
                    return 28;
                }
                return 30;
            }
        }
    }

