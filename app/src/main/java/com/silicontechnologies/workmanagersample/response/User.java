package com.silicontechnologies.workmanagersample.response;

import com.google.gson.annotations.SerializedName;

public class User {

  @SerializedName("mobile")
  private String mobile;
  @SerializedName("email")
  private String email;
  @SerializedName("name")
  private String name;
  @SerializedName("id")
  private int id;
}
