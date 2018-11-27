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

package com.metamx.datatypes.openrtb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Device
{
  private final Integer dnt;
  private final String ua;
  private final String ip;
  private final String ipv6;
  private final Geo geo;
  private final Integer lmt;
  private final String didsha1;
  private final String didmd5;
  private final String dpidsha1;
  private final String dpidmd5;
  private final String macsha1;
  private final String macmd5;
  private final String carrier;
  private final String language;
  private final String make;
  private final String model;
  private final String os;
  private final String osVer;
  private final String hwv;
  private final Integer height;
  private final Integer width;
  private final Integer ppi;
  private final Double pxratio;
  private final Integer jsSupport;
  private final Integer connectionType;
  private final Integer deviceType;
  private final String flashVer;
  private final String ifa;
  private final Ext ext;

  public Device(
      @JsonProperty("dnt") Integer dnt,
      @JsonProperty("ua") String ua,
      @JsonProperty("ip") String ip,
      @JsonProperty("ipv6") String ipv6,
      @JsonProperty("geo") Geo geo,
      @JsonProperty("lmt") Integer lmt,
      @JsonProperty("didsha1") String didsha1,
      @JsonProperty("didmd5") String didmd5,
      @JsonProperty("dpidsha1") String dpidsha1,
      @JsonProperty("dpidmd5") String dpidmd5,
      @JsonProperty("macsha1") String macsha1,
      @JsonProperty("macmd5") String macmd5,
      @JsonProperty("carrier") String carrier,
      @JsonProperty("language") String language,
      @JsonProperty("make") String make,
      @JsonProperty("model") String model,
      @JsonProperty("os") String os,
      @JsonProperty("osv") String osVer,
      @JsonProperty("hwv") String hwv,
      @JsonProperty("h") Integer height,
      @JsonProperty("w") Integer width,
      @JsonProperty("ppi") Integer ppi,
      @JsonProperty("pxratio") Double pxratio,
      @JsonProperty("js") Integer jsSupport,
      @JsonProperty("connectiontype") Integer connectionType,
      @JsonProperty("devicetype") Integer deviceType,
      @JsonProperty("flashver") String flashVer,
      @JsonProperty("ifa") String ifa,
      @JsonProperty("ext") Ext ext
  )
  {
    this.dnt = dnt;
    this.ua = ua;
    this.ip = ip;
    this.ipv6 = ipv6;
    this.geo = geo;
    this.lmt = lmt;
    this.didsha1 = didsha1;
    this.didmd5 = didmd5;
    this.dpidsha1 = dpidsha1;
    this.dpidmd5 = dpidmd5;
    this.macsha1 = macsha1;
    this.macmd5 = macmd5;
    this.carrier = carrier;
    this.language = language;
    this.make = make;
    this.model = model;
    this.os = os;
    this.osVer = osVer;
    this.hwv = hwv;
    this.height = height;
    this.width = width;
    this.ppi = ppi;
    this.pxratio = pxratio;
    this.jsSupport = jsSupport;
    this.connectionType = connectionType;
    this.deviceType = deviceType;
    this.flashVer = flashVer;
    this.ifa = ifa;
    this.ext = ext;
  }

  @JsonProperty
  public Integer getDnt()
  {
    return dnt;
  }

  @JsonProperty
  public String getUa()
  {
    return ua;
  }

  @JsonProperty
  public String getIp()
  {
    return ip;
  }

  @JsonProperty
  public Geo getGeo()
  {
    return geo;
  }

  @JsonProperty
  public String getDidsha1()
  {
    return didsha1;
  }

  @JsonProperty
  public String getDidmd5()
  {
    return didmd5;
  }

  @JsonProperty
  public String getDpidsha1()
  {
    return dpidsha1;
  }

  @JsonProperty
  public String getDpidmd5()
  {
    return dpidmd5;
  }

  @JsonProperty
  public String getMacsha1()
  {
    return macsha1;
  }

  @JsonProperty
  public String getMacmd5()
  {
    return macmd5;
  }

  @JsonProperty
  public String getCarrier()
  {
    return carrier;
  }

  @JsonProperty
  public String getLanguage()
  {
    return language;
  }

  @JsonProperty
  public String getMake()
  {
    return make;
  }

  @JsonProperty
  public String getModel()
  {
    return model;
  }

  @JsonProperty
  public String getOs()
  {
    return os;
  }

  @JsonProperty("osv")
  public String getOsVer()
  {
    return osVer;
  }

  @JsonProperty
  public String getIpv6()
  {
    return ipv6;
  }

  @JsonProperty
  public Integer getLmt()
  {
    return lmt;
  }

  @JsonProperty
  public String getHwv()
  {
    return hwv;
  }

  @JsonProperty("h")
  public Integer getHeight()
  {
    return height;
  }

  @JsonProperty("w")
  public Integer getWidth()
  {
    return width;
  }

  @JsonProperty
  public Integer getPpi()
  {
    return ppi;
  }

  @JsonProperty
  public Double getPxratio()
  {
    return pxratio;
  }

  @JsonProperty("js")
  public Integer getJsSupport()
  {
    return jsSupport;
  }

  @JsonProperty("connectiontype")
  public Integer getConnectionType()
  {
    return connectionType;
  }

  @JsonProperty("devicetype")
  public Integer getDeviceType()
  {
    return deviceType;
  }

  @JsonProperty("flashver")
  public String getFlashVer()
  {
    return flashVer;
  }

  @JsonProperty
  public String getIfa()
  {
    return ifa;
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
    private Integer dnt;
    private String ua;
    private String ip;
    private String ipv6;
    private Geo geo;
    private Integer lmt;
    private String didsha1;
    private String didmd5;
    private String dpidsha1;
    private String dpidmd5;
    private String macsha1;
    private String macmd5;
    private String carrier;
    private String language;
    private String make;
    private String model;
    private String os;
    private String osVer;
    private String hwv;
    private Integer height;
    private Integer width;
    private Integer ppi;
    private Double pxratio;
    private Integer jsSupport;
    private Integer connectionType;
    private Integer deviceType;
    private String flashVer;
    private String ifa;
    private Ext ext;

    public Builder() {}

    public Builder dnt(final Integer dnt)
    {
      this.dnt = dnt;
      return this;
    }

    public Builder ua(final String ua)
    {
      this.ua = ua;
      return this;
    }

    public Builder ip(final String ip)
    {
      this.ip = ip;
      return this;
    }

    public Builder ipv6(final String ipv6)
    {
      this.ipv6 = ipv6;
      return this;
    }

    public Builder geo(final Geo geo)
    {
      this.geo = geo;
      return this;
    }

    public Builder lmt(final Integer lmt)
    {
      this.lmt = lmt;
      return this;
    }

    public Builder didsha1(final String didsha1)
    {
      this.didsha1 = didsha1;
      return this;
    }

    public Builder didmd5(final String didmd5)
    {
      this.didmd5 = didmd5;
      return this;
    }

    public Builder dpidsha1(final String dpidsha1)
    {
      this.dpidsha1 = dpidsha1;
      return this;
    }

    public Builder dpidmd5(final String dpidmd5)
    {
      this.dpidmd5 = dpidmd5;
      return this;
    }

    public Builder macsha1(final String macsha1)
    {
      this.macsha1 = macsha1;
      return this;
    }

    public Builder macmd5(final String macmd5)
    {
      this.macmd5 = macmd5;
      return this;
    }

    public Builder carrier(final String carrier)
    {
      this.carrier = carrier;
      return this;
    }

    public Builder language(final String language)
    {
      this.language = language;
      return this;
    }

    public Builder make(final String make)
    {
      this.make = make;
      return this;
    }

    public Builder model(final String model)
    {
      this.model = model;
      return this;
    }

    public Builder os(final String os)
    {
      this.os = os;
      return this;
    }

    public Builder osVer(final String osVer)
    {
      this.osVer = osVer;
      return this;
    }

    public Builder hwv(final String hwv)
    {
      this.hwv = hwv;
      return this;
    }

    public Builder height(final Integer height)
    {
      this.height = height;
      return this;
    }

    public Builder width(final Integer width)
    {
      this.width = width;
      return this;
    }

    public Builder ppi(final Integer ppi)
    {
      this.ppi = ppi;
      return this;
    }

    public Builder pxratio(final Double pxratio)
    {
      this.pxratio = pxratio;
      return this;
    }

    public Builder jsSupport(final Integer jsSupport)
    {
      this.jsSupport = jsSupport;
      return this;
    }

    public Builder connectionType(final Integer connectionType)
    {
      this.connectionType = connectionType;
      return this;
    }

    public Builder deviceType(final Integer deviceType)
    {
      this.deviceType = deviceType;
      return this;
    }

    public Builder flashVer(final String flashVer)
    {
      this.flashVer = flashVer;
      return this;
    }

    public Builder ifa(final String ifa)
    {
      this.ifa = ifa;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public Device build()
    {
      return new Device(
          dnt,
          ua,
          ip,
          ipv6,
          geo,
          lmt,
          didsha1,
          didmd5,
          dpidsha1,
          dpidmd5,
          macsha1,
          macmd5,
          carrier,
          language,
          make,
          model,
          os,
          osVer,
          hwv,
          height,
          width,
          ppi,
          pxratio,
          jsSupport,
          connectionType,
          deviceType,
          flashVer,
          ifa,
          ext
      );
    }
  }
}
