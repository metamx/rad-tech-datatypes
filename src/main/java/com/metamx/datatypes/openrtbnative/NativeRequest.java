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
  private final Integer layout;
  private final Integer adunit;
  private final Integer plcmtcnt;
  private final Integer seq;
  private final List<AssetRequest> assets;
  private final Ext ext;

  public NativeRequest(
      @JsonProperty("ver") String ver,
      @JsonProperty("layout") Integer layout,
      @JsonProperty("adunit") Integer adunit,
      @JsonProperty("plcmtcnt") Integer plcmtcnt,
      @JsonProperty("seq") Integer seq,
      @JsonProperty("assets") List<AssetRequest> assets,
      @JsonProperty("ext") Ext ext
  )
  {
    this.ver = ver;
    this.layout = layout;
    this.adunit = adunit;
    this.plcmtcnt = plcmtcnt;
    this.seq = seq;
    this.assets = assets;
    this.ext = ext;
  }

  @JsonProperty
  public String getVer()
  {
    return ver;
  }

  @JsonProperty
  public Integer getLayout()
  {
    return layout;
  }

  @JsonProperty
  public Integer getAdUnit()
  {
    return adunit;
  }

  @JsonProperty
  public Integer getPlcmtcnt()
  {
    return plcmtcnt;
  }

  @JsonProperty
  public Integer getSeq()
  {
    return seq;
  }

  @JsonProperty
  public List<AssetRequest> getAssets()
  {
    return assets;
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
    private Integer layout;
    private Integer adunit;
    private Integer plcmtcnt;
    private Integer seq;
    private List<AssetRequest> assets;
    private Ext ext;

    public Builder() {}

    public Builder ver(final String ver)
    {
      this.ver = ver;
      return this;
    }

    public Builder layout(final Integer layout)
    {
      this.layout = layout;
      return this;
    }

    public Builder adunit(final Integer adunit)
    {
      this.adunit = adunit;
      return this;
    }

    public Builder plcmtcnt (final Integer plcmtcnt)
    {
      this.plcmtcnt = plcmtcnt;
      return this;
    }

    public Builder seq (final Integer seq)
    {
      this.seq = seq;
      return this;
    }

    public Builder assets(final List<AssetRequest> assets)
    {
      this.assets = assets;
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
          ver,
          layout,
          adunit,
          plcmtcnt,
          seq,
          assets,
          ext
      );
    }
  }

}