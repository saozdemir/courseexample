package sessionmanager.app;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinBase.SYSTEMTIME;
import com.sun.jna.platform.win32.WinNT.HANDLE;

/**
 * @author saozd
 * @project sessionmanager.app courseexample
 * 13.07.2023 Tem 2023
 */
public class SessionManagerApp2 {
    public static void main(String[] args) {
        long unlockTime = getSessionUnlockTime();
        System.out.println("Session unlock time: " + unlockTime + " milliseconds");

        long lockTime = getSessionLockTime();
        System.out.println("Session lock time: " + lockTime + " milliseconds");

    }

    public static long getSessionUnlockTime() {
        HANDLE handle = Kernel32.INSTANCE.GetStdHandle(Kernel32.STD_INPUT_HANDLE);
        int sessionId = Kernel32.INSTANCE.GetProcessId(handle);

        User32.LASTINPUTINFO lastInputInfo = new User32.LASTINPUTINFO();
        int dwTime = lastInputInfo.dwTime;
        //long lastInputTime = Kernel32.INSTANCE.GetLastInputInfo();
        //long lastInputTime = new User32.LASTINPUTINFO();


        SYSTEMTIME systemTime = new SYSTEMTIME();
        Kernel32.INSTANCE.GetSystemTime(systemTime);

        long currentSystemTime = (systemTime.wHour * 3600 + systemTime.wMinute * 60 + systemTime.wSecond) * 1000 + systemTime.wMilliseconds;
        long unlockTime = currentSystemTime - dwTime;

        return unlockTime;
    }

    public static long getSessionLockTime() {
        long unlockTime = getSessionUnlockTime();
        long lockTime = System.currentTimeMillis() - unlockTime;

        return lockTime;
    }
}
