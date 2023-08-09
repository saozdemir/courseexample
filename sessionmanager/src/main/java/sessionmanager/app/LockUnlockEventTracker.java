package sessionmanager.app;

/**
 * @author saozd
 * @project sessionmanager.app courseexample
 * 13.07.2023 Tem 2023
 */
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LockUnlockEventTracker implements NativeKeyListener {

    private Map<Integer, LocalDateTime> lockEvents;
    private Map<Integer, LocalDateTime> unlockEvents;

    public LockUnlockEventTracker() {
        lockEvents = new HashMap<>();
        unlockEvents = new HashMap<>();
    }

    public void startTracking() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            ex.printStackTrace();
            return;
        }

        GlobalScreen.addNativeKeyListener(this);
    }

    public void stopTracking() {
        GlobalScreen.removeNativeKeyListener(this);

        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        // İstenilen tuşa basıldığında kilitlenme olayını kaydet
        if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CAPS_LOCK) {
            int keyCode = nativeKeyEvent.getKeyCode();
            if (!lockEvents.containsKey(keyCode)) {
                lockEvents.put(keyCode, LocalDateTime.now());
                System.out.println("Kilitlendi: " + LocalDateTime.now());
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        // İstenilen tuşun bırakıldığında kilidi açma olayını kaydet
        if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CAPS_LOCK) {
            int keyCode = nativeKeyEvent.getKeyCode();
            if (!unlockEvents.containsKey(keyCode)) {
                unlockEvents.put(keyCode, LocalDateTime.now());
                System.out.println("Kilidi açıldı: " + LocalDateTime.now());
            }
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        // Herhangi bir işlem yapma
    }

    public Duration calculateLockUnlockTime(int keyCode) {
        LocalDateTime lockTime = lockEvents.get(keyCode);
        LocalDateTime unlockTime = unlockEvents.get(keyCode);

        if (lockTime != null && unlockTime != null) {
            return Duration.between(lockTime, unlockTime);
        } else {
            return Duration.ZERO;
        }
    }

    public static void main(String[] args) {
        LockUnlockEventTracker eventTracker = new LockUnlockEventTracker();
        eventTracker.startTracking();

        // Bekleme süresi
        try {
            Thread.sleep(60000); // Örnek olarak 1 dakika bekleniyor
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        eventTracker.stopTracking();

        Duration lockUnlockTime = eventTracker.calculateLockUnlockTime(NativeKeyEvent.VC_CAPS_LOCK);
        System.out.println("Toplam kilitlenme süresi: " + lockUnlockTime);
    }
}
