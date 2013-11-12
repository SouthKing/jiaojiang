package companies.facebook.mitbbs;

import utils.Utils;

import java.util.*;

/**
 * @author: mizhang
 * @since: Nov 11, 2013 10:48:38 AM
 */
public class OnlineUser {
    /*
    Given a log file of user login info, find out the total number of users logged in in a certain period of time. For
    example,
    Given:
        user1:
        login_time: 0
        logout_time: 1

        user2:
        login_time: 0
        logout_time: 2

        user3:
        login_time: 1
        logout_time: 3

    output:
    [0 - 2): 2
    [2 - 3): 1
    [3 - infinite): 0
     */
    private static class Log {
        long logginTime;
        long loggoutTime;

        public Log(long loggin, long logout) {
            logginTime = loggin;
            loggoutTime = logout;
        }
    }

    private static class UserCount {
        long start;
        long end;
        long userCount;

        public String toString() {
            return "[" + start + ", " + end + "]: " + userCount + "\n";
        }
    }

    public static List<UserCount> onlineUser(List<Log> logs) {
        List<UserCount> ret = new ArrayList<UserCount>();

        Collections.sort(logs, new Comparator<Log>() {
            @Override
            public int compare(Log log1, Log log2) {
                return (int)(log1.logginTime - log2.logginTime);
            }
        });

        
        




        return ret;
    }

    private static void test() {
        Utils.printList(onlineUser(Arrays.asList(new Log(0, 1), new Log(0, 2), new Log(1, 3))));
    }

    public static void main(String[] args) {
        test();
    }
}
