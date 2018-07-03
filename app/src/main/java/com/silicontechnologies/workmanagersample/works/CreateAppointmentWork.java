package com.silicontechnologies.workmanagersample.works;

import android.support.annotation.NonNull;
import androidx.work.Worker;
import com.silicontechnologies.workmanagersample.base.BaseWorker;

public class CreateAppointmentWork extends BaseWorker {

  private String primaryKey;

  public CreateAppointmentWork(String primaryKey) {
    this.primaryKey = primaryKey;
  }

  private static final String TAG = CreateAppointmentWork.class.getSimpleName();

  @NonNull @Override public WorkerResult doWork() {

    return null;
  }
}
