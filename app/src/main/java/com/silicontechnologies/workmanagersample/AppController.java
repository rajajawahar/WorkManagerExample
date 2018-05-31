package com.silicontechnologies.workmanagersample;

import android.app.Application;
import androidx.work.WorkManager;

public class AppController extends Application {

  @Override public void onCreate() {
    super.onCreate();
  }

  public static WorkManager getWorkManager() {
    return WorkManager.getInstance();
  }
}
