package OpSys;

/**
 * Created by survari on 06.09.16.
 */
public class System {

    private static String OS = java.lang.System.getProperty("os.name").toLowerCase();
    public static int OSN = getOSNum();

    public static boolean isWindows() {

        return (OS.indexOf("win") >= 0);

    }

    public static boolean isMac() {

        return (OS.indexOf("mac") >= 0);

    }

    public static boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );

    }

    public static boolean isSolaris() {

        return (OS.indexOf("sunos") >= 0);

    }

    public static int getOSNum()
    {
        if (isUnix())
            return 1;
        else if (isSolaris())
            return 2;
        else if (isMac())
            return 3;
        else if (isWindows())
            return 4;
        else
            return 5;
    }

    public static void setOSNum(int num)
    {
        OSN = num;
    }

}
