package demo.nimmsta.core;

import com.nimmsta.core.shared.device.NIMMSTADevice;
import com.nimmsta.core.shared.promise.NIMMSTADoneCallback;
import com.nimmsta.core.shared.promise.NIMMSTAFailCallback;
import com.nimmsta.core.shared.textprotocolapi.softwareupdate.SoftwareFileContext;
import com.nimmsta.core.shared.textprotocolapi.softwareupdate.model.ReleaseFileInfo;
import com.soywiz.korio.file.std.LocalVfsJvmKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

public class UpdateCommand implements Command {
    private NIMMSTADevice device;
    private String updatePath;

    public boolean allowToExecute = false;

    UpdateCommand() {
        this.device = null;
        this.updatePath = null;
    }
    UpdateCommand(NIMMSTADevice device, String updatePath) {
        this.device = device;
        this.updatePath = updatePath;
    }
    public void execute() {
        if (!allowToExecute)  { return; }
        device.getApi().checkSoftwareUpdate(LocalVfsJvmKt.localVfs(updatePath), new Function3<Boolean, SoftwareFileContext, ReleaseFileInfo, Unit>() {
                    @Override
                    public Unit invoke(Boolean isAlreadyInstalled, SoftwareFileContext softwareFileContext, ReleaseFileInfo versions) {
                        if (isAlreadyInstalled) {
                            // if the version is already installed
                        } else {
                            softwareFileContext.sendToDeviceAsync().onSuccess(new NIMMSTADoneCallback<Unit>() {
                                @Override
                                public void onDone(Unit unit) {
                                    // disconnect and tell user to restart device to install update
                                }
                            }).onError(new NIMMSTAFailCallback<Throwable>() {
                                @Override
                                public void onFail(Throwable throwable) {
                                    // error occurred while trying to send software update to device
                                    // tell user to restart device and try again
                                }
                            });
                        }
                        return null;
                    }
                })
                .onError(new NIMMSTAFailCallback<Throwable>() {
                    @Override
                    public void onFail(Throwable throwable) {
                        // If there is an error with the file
                    }
                });
    }

    public void setDevice(NIMMSTADevice device) {
        this.device = device;
    }

    public void setUpdatePath(String updatePath) {
        this.updatePath = updatePath;
    }
}
