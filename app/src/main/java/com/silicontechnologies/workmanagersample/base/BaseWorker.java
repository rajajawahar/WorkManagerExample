package com.silicontechnologies.workmanagersample.base;

import androidx.work.Worker;
import com.silicontechnologies.workmanagersample.WorkManagerRepo;
import com.silicontechnologies.workmanagersample.app.AppController;

public abstract class BaseWorker extends Worker {

  protected WorkManagerRepo workManagerRepo;

  public BaseWorker() {
    workManagerRepo = AppController.getInstance().getWorkManagerRepo();
  }
}
