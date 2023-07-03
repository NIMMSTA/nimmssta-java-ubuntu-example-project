package demo.nimmsta.core;

import com.nimmsta.barcode.Barcode;
import com.nimmsta.core.shared.device.NIMMSTADevice;
import com.nimmsta.core.shared.device.NIMMSTAEventHandler;
import com.nimmsta.core.shared.exception.bluetooth.BluetoothDisconnectedException;
import com.nimmsta.core.shared.layout.element.Button;
import com.nimmsta.core.shared.layout.event.ButtonClickEvent;
import com.nimmsta.core.shared.lighttag.LightTagList;
import com.nimmsta.core.shared.promise.NIMMSTADoneCallback;
import com.nimmsta.core.shared.promise.NIMMSTAFailCallback;
import com.nimmsta.core.shared.textprotocol.event.Event;
import com.nimmsta.core.shared.textprotocol.event.RequestShutdown;
import com.nimmsta.core.shared.textprotocol.event.ScanEvent;
import com.nimmsta.core.shared.textprotocol.event.TouchEvent;
import com.nimmsta.core.shared.textprotocolapi.softwareupdate.SoftwareFileContext;
import com.nimmsta.core.shared.textprotocolapi.softwareupdate.model.ReleaseFileInfo;
import com.nimmsta.core.shared.textprotocolapi.softwareupdate.model.SoftwareUpdateProgress;
import com.soywiz.korio.file.std.LocalVfsJvmKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DemoEventHandler implements NIMMSTAEventHandler {

    private UpdateCommand updateCommand;


    DemoEventHandler(){
        this.updateCommand = new UpdateCommand();
    }
    @Override
    public void didStartConnecting(NIMMSTADevice nimmstaDevice) {
        // Connection process has started
        // Device interaction not yet possible
    }

    @Override
    public void didConnectAndInit(NIMMSTADevice nimmstaDevice) {
        updateCommand.setDevice(nimmstaDevice);
        updateCommand.setUpdatePath("<UPDATE_PATH>"); // TODO set update path
        updateCommand.execute();
    }

    @Override
    public boolean allowShutdownByUser(@NotNull NIMMSTADevice nimmstaDevice, @NotNull RequestShutdown requestShutdown) {
        return true;
    }

    @Override
    public void batteryLevelChanged(@NotNull NIMMSTADevice nimmstaDevice, int i) {

    }

    @Override
    public boolean deviceShouldHandover(@NotNull NIMMSTADevice nimmstaDevice) {
        return false;
    }

    @Override
    public boolean deviceWillShutdown(@NotNull NIMMSTADevice nimmstaDevice, boolean b) {
        return false;
    }

    @Override
    public void didClickButton(@NotNull NIMMSTADevice nimmstaDevice, @Nullable Button button, @NotNull ButtonClickEvent buttonClickEvent) {

    }

    @Override
    public void didDisconnect(@NotNull NIMMSTADevice nimmstaDevice, @NotNull BluetoothDisconnectedException.Reason reason) {

    }

    @Override
    public void didReceiveEvent(@NotNull NIMMSTADevice nimmstaDevice, @NotNull Event event) {

    }

    @Override
    public void didScanBarcode(@NotNull NIMMSTADevice nimmstaDevice, @NotNull Barcode barcode, @NotNull ScanEvent scanEvent) {

    }

    @Override
    public void didStartCharging(@NotNull NIMMSTADevice nimmstaDevice) {

    }

    @Override
    public void didStartReconnectSearch(@NotNull NIMMSTADevice nimmstaDevice) {

    }

    @Override
    public void didStopCharging(@NotNull NIMMSTADevice nimmstaDevice) {

    }

    @Override
    public void didStopReconnectSearch(@NotNull NIMMSTADevice nimmstaDevice) {

    }

    @Override
    public void didTouch(@NotNull NIMMSTADevice nimmstaDevice, double v, double v1, int i, @NotNull TouchEvent touchEvent) {

    }

    @Override
    public boolean onError(@Nullable NIMMSTADevice nimmstaDevice, @NotNull Throwable throwable) {
        return false;
    }

    @Override
    public void softwareUpdateProgress(@NotNull NIMMSTADevice nimmstaDevice, @NotNull SoftwareUpdateProgress softwareUpdateProgress) {
        System.out.println("Software update progress: " + softwareUpdateProgress);
    }

    @Override
    public void softwareUpgradeProgress(@NotNull NIMMSTADevice nimmstaDevice, @NotNull SoftwareUpdateProgress softwareUpdateProgress) {

    }

    private void updateDevice(NIMMSTADevice device, String updatePath) {
    }
}