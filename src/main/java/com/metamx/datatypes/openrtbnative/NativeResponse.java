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
public class NativeResponse
{
  private final String ver;
  private final List<AssetObj> assets;
  private final Link link;
  private final List<String> imptrackers;
  private final String jstracker;
  private final Ext ext;

  public NativeResponse(
      @JsonProperty("ver") String ver,
      @JsonProperty("assets") List<AssetObj> assets,
      @JsonProperty("link") Link link,
      @JsonProperty("imptrackers") List<String> imptrackers,
      @JsonProperty("jstracker") String jstracker,
      @JsonProperty("ext") Ext ext
  )
  {
    this.ver = ver;
    this.assets = assets;
    this.link = link;
    this.imptrackers = imptrackers;
    this.jstracker = jstracker;
    this.ext = ext;
  }

  @JsonProperty
  public String getVer()
  {
    return ver;
  }

  @JsonProperty
  public List<AssetObj> getAssets()
  {
    return assets;
  }

  @JsonProperty
  public Link getLink ()
  {
    return link;
  }

  @JsonProperty
  public List<String> getImptrackers()
  {
    return imptrackers;
  }

  @JsonProperty
  public String getJstracker()
  {
    return jstracker;
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
    private String ver;
    private List<AssetObj> assets;
    private Link link;
    private List<String> imptrackers;
    private String jstracker;
    private Ext ext;

    public Builder() {}

    public Builder ver(final String ver)
    {
      this.ver = ver;
      return this;
    }

    public Builder assets(final List<AssetObj> assets)
    {
      this.assets = assets;
      return this;
    }

    public Builder link(final Link link)
    {
      this.link = link;
      return this;
    }

    public Builder imptrackers (final List<String> imptrackers)
    {
      this.imptrackers = imptrackers;
      return this;
    }

    public Builder jstracker (final String jstracker)
    {
      this.jstracker = jstracker;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public NativeResponse build()
    {
      return new NativeResponse(
          ver,
          assets,
          link,
          imptrackers,
          jstracker,
          ext
          );
    }
  }

}