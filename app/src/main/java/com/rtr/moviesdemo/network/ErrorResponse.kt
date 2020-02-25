package com.rtr.moviesdemo.network

import com.fasterxml.jackson.annotation.JsonProperty

data class ErrorResponse (
  @JsonProperty("status_message") val statusMessage:String,
  @JsonProperty("status_code") val statusCode:String,
  @JsonProperty("success")val success:Boolean
)
