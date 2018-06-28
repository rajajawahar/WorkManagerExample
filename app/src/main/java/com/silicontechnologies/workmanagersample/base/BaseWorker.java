package com.silicontechnologies.workmanagersample.base;

import android.support.annotation.NonNull;
import androidx.work.Worker;
import com.silicontechnologies.workmanagersample.WorkManagerRepo;
import com.silicontechnologies.workmanagersample.app.AppController;

public class BaseWorker extends Worker {

  protected WorkManagerRepo workManagerRepo;

  public BaseWorker() {
    workManagerRepo = AppController.getInstance().getWorkManagerRepo();
  }

  @NonNull @Override public WorkerResult doWork() {
    return null;
  }
}
