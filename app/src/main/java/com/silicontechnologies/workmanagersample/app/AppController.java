package com.silicontechnologies.workmanagersample.app;

import android.app.Application;
import androidx.work.WorkManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.silicontechnologies.workmanagersample.BuildConfig;
import com.silicontechnologies.workmanagersample.WorkManagerApi;
import com.silicontechnologies.workmanagersample.WorkManagerRepo;
import com.silicontechnologies.workmanagersample.utils.RxErrorTransformationCallAdapterFactory;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppController extends Application {

  private Gson gson;
  private HttpLoggingInterceptor logging;
  private WorkManagerRepo workManagerRepo;
  private static AppController instance;

  @Override public void onCreate() {
    super.onCreate();
    instance = this;
    gson = new GsonBuilder().create();
    logging = new HttpLoggingInterceptor();
    logging.setLevel(
        BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
  }

  public static AppController getInstance() {
    return instance;
  }

  public static WorkManager getWorkManager() {
    return WorkManager.getInstance();
  }

  private WorkManagerRepo createWorkManagerRepo() {
    OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(logging)
        .connectTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100, TimeUnit.SECONDS)
        .build();
    Retrofit retrofit = new Retrofit.Builder().client(httpClient)
        .baseUrl(ApiConstants.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addCallAdapterFactory(new RxErrorTransformationCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
    return new WorkManagerRepo(retrofit.create(WorkManagerApi.class));
  }

  public WorkManagerRepo getWorkManagerRepo() {
    if (workManagerRepo == null) {
      workManagerRepo = createWorkManagerRepo();
    }

    return workManagerRepo;
  }
}
