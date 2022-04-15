/*
Given a time in -hour AM/PM format, convert it to military (24-hour) time.

Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.

Example
s = '12:01:00PM'
Return '12:01:00'.

s = '12:01:00AM'
Return '00:01:00'.

Function Description

Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.
timeConversion has the following parameter(s):
string s: a time in  hour format
Returns
string: the time in  hour format
Input Format

A single string  that represents a time in -hour clock format (i.e.:  or ).

Plan

add 12 to the first string?

In case of AM
- add 12 to first spot in call cases except
- if first spot is 12 and second two spots are not 00
    - in this case 12 becomes zero and the other values stay the same

In case of PM
- add 12 to the first spot in all cases except
-   if the first spot is 12 and the second two spots are not 00
 - in this case everything stays the same

 check the edge case 12:00:00 = 00:00:00
*/

public class timeConversion {
    public static String militaryConversion(String s) {
        String timestamp = s.substring(s.length() -2, s.length());
        String hour = s.substring(0, 2);;
        String min = s.substring(3, 5);;
        String sec = s.substring(6, 8);;
        String military = "";
        
        if(timestamp.equals("AM")){
            if(hour.equals("12") && (min.equals("00") && (sec.equals("00")))){
                military += "00" + ":" + min + ":" + sec;
            }
            else if(hour.equals("12") && ((!min.equals("00")) || (!sec.equals("00")))){
                military += "00:" + min + ":" + sec;
            }else{
                military += hour + ":" + min + ":" + sec;
            }
            return military;
            
        }else if(timestamp.equals("PM")){
            if(hour.equals("12") && (min.equals("00") && (sec.equals("00")))){
                military += "00" + ":" + min + ":" + sec;
            }
            else if(hour.equals("12") && ((!min.equals("00")) || (!sec.equals("00")))){
                military += "12:" + min + ":" + sec;
            }else{
                int temphour = Integer.parseInt(hour) + 12;
                military += temphour + ":" + min + ":" + sec;
            }
            return military;
        }
        
        return military;
        }

        public static void main (String [] args){
            String a = "07:05:45PM"; // expected 19:05:45
            String b = "04:59:59AM"; // expected 04:59:59
            String c = "12:00:00AM"; // expected 00:00:00
            String d = "12:01:00AM"; // expected 00:01:00
            System.out.println(timeConversion.militaryConversion(a));
            System.out.println(timeConversion.militaryConversion(b));
            System.out.println(timeConversion.militaryConversion(c));
            System.out.println(timeConversion.militaryConversion(d));
        }
}
