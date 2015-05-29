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
import com.metamx.datatypes.openrtb.Video;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AssetRequest
{
  private final Integer id;
  private final Integer req;
  private final TitleRequest title;
  private final ImageRequest img;
  private final VideoRequest video;
  private final DataRequest data;
  private final Ext ext;

  public AssetRequest(
      @JsonProperty("id") Integer id,
      @JsonProperty("req") Integer req,
      @JsonProperty("title") TitleRequest title,
      @JsonProperty("img") ImageRequest img,
      @JsonProperty("video") VideoRequest video,
      @JsonProperty("data") DataRequest data,
      @JsonProperty("ext") Ext ext
  )
  {
    this.id = id;
    this.req = req;
    this.title = title;
    this.img = img;
    this.video = video;
    this.data = data;
    this.ext = ext;
  }

  @JsonProperty
  public Integer getId()
  {
    return id;
  }

  @JsonProperty
  public Integer getReq()
  {
    return req;
  }

  @JsonProperty
  public TitleRequest getTitle()
  {
    return title;
  }

  @JsonProperty
  public ImageRequest getImg()
  {
    return img;
  }

  @JsonProperty
  public VideoRequest getVideo()
  {
    return video;
  }

  @JsonProperty
  public DataRequest getData()
  {
    return data;
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
    private Integer id;
    private Integer req;
    private TitleRequest title;
    private ImageRequest img;
    private VideoRequest video;
    private DataRequest data;
    private Ext ext;

    public Builder() {}

    public Builder id(final Integer id)
    {
      this.id = id;
      return this;
    }

    public Builder req(final Integer req)
    {
      this.req = req;
      return this;
    }

    public Builder title(final TitleRequest title)
    {
      this.title = title;
      return this;
    }

    public Builder img(final ImageRequest img)
    {
      this.img = img;
      return this;
    }

    public Builder video(final VideoRequest video)
    {
      this.video = video;
      return this;
    }

    public Builder data(final DataRequest data)
    {
      this.data = data;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public AssetRequest build()
    {
      return new AssetRequest(
          id,
          req,
          title,
          img,
          video,
          data,
          ext
      );
    }
  }

}