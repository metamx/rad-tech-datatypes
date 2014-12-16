/*
 * Rad-tech-datatypes.
 * Copyright 2014 Metamarkets Group Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.metamx.datatypes.openrtbnative;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.metamx.datatypes.openrtb.Ext;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NativeRequest
{
  private final String ver;
  private final int layout;
  private final int adunit;
  private final int plcmtcnt;
  private final int seq;
  private final List<AssetObj> assets;
  private final Ext ext;

  public NativeRequest(
      @JsonProperty("request") String request,
      @JsonProperty("ver") String ver,
      @JsonProperty("api") List<Integer> api,
      @JsonProperty("battr") List<Integer> battr,
      @JsonProperty("ext") Ext ext
  )
  {
    this.request = request;
    this.ver = ver;
    this.api = api;
    this.battr = battr;
    this.ext = ext;
  }

  @JsonProperty
  public String getRequest()
  {
    return request;
  }

  @JsonProperty
  public String getVer()
  {
    return ver;
  }

  @JsonProperty
  public List<Integer> getApi()
  {
    return api;
  }

  @JsonProperty
  public List<Integer> getBattr()
  {
    return battr;
  }

  @JsonProperty
  public Ext getExt()
  {
    return ext;
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public static class Builder
  {
    private String request;
    private String ver = "1";
    private List<Integer> api;
    private List<Integer> battr;
    private Ext ext;

    public Builder() {}

    public Builder request(final String request)
    {
      this.request = request;
      return this;
    }

    public Builder ver(final String ver)
    {
      this.ver = ver;
      return this;
    }

    public Builder api(final List<Integer> api)
    {
      this.api = api;
      return this;
    }

    public Builder battr(final List<Integer> battr)
    {
      this.battr = battr;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public NativeRequest build()
    {
      return new NativeRequest(
          request,
          ver,
          api,
          battr,
          ext
      );
    }
  }

}
