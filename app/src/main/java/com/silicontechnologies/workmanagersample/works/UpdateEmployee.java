package com.silicontechnologies.workmanagersample.works;

import android.support.annotation.NonNull;
import androidx.work.Worker;

public class UpdateEmployee extends Worker {

  private static final String TAG = UpdateEmployee.class.getSimpleName();

  @NonNull @Override public WorkerResult doWork() {

    if (true) {
      return WorkerResult.SUCCESS;
    } else {
      return WorkerResult.FAILURE;
    }
  }
}
