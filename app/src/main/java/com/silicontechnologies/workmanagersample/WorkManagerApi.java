package com.silicontechnologies.workmanagersample;

import com.google.gson.JsonObject;
import com.silicontechnologies.workmanagersample.response.Appointment;
import com.silicontechnologies.workmanagersample.response.User;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WorkManagerApi {

  @POST("/mobi_appoinment_api_v2/user/login")
  Observable<User> login(@Body JsonObject loginObject);

  @POST("/mobi_appoinment_api_v2/user/register")
  Observable<User> signUp(@Body JsonObject loginObject);

  @POST("/mobi_appoinment_api_v2/appointments/check_in_store/{userId}")
  Observable<Appointment> checkIn(@Path("userId") Integer userId, @Body JsonObject loginObject);

  @POST("/mobi_appoinment_api_v2/appointments/check_out_store")
  Observable<Appointment> checkOut(@Body JsonObject loginObject);
}
