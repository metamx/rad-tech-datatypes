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
public class AssetResponse
{
  private final Integer id;
  private final Integer required;
  private final TitleResponse title;
  private final ImageResponse img;
  private final VideoResponse video;
  private final DataResponse data;
  private final Link link;
  private final Ext ext;

  public AssetResponse(
      @JsonProperty("id") Integer id,
      @JsonProperty("required") Integer required,
      @JsonProperty("title") TitleResponse title,
      @JsonProperty("img") ImageResponse img,
      @JsonProperty("video") VideoResponse video,
      @JsonProperty("data") DataResponse data,
      @JsonProperty("link") Link link,
      @JsonProperty("ext") Ext ext
  )
  {
    this.id = id;
    this.required = required;
    this.title = title;
    this.img = img;
    this.video = video;
    this.data = data;
    this.link = link;
    this.ext = ext;
  }

  @JsonProperty
  public Integer getId()
  {
    return id;
  }

  @JsonProperty
  public Integer getRequired()
  {
    return required;
  }

  @JsonProperty
  public TitleResponse getTitle()
  {
    return title;
  }

  @JsonProperty
  public ImageResponse getImg()
  {
    return img;
  }

  @JsonProperty
  public VideoResponse getVideo()
  {
    return video;
  }

  @JsonProperty
  public DataResponse getData()
  {
    return data;
  }

  @JsonProperty
  public Link getLink()
  {
    return link;
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
    private Integer required;
    private TitleResponse title;
    private ImageResponse img;
    private VideoResponse video;
    private DataResponse data;
    private Link link;
    private Ext ext;

    public Builder() {}

    public Builder id(final Integer id)
    {
      this.id = id;
      return this;
    }

    public Builder required(final Integer required)
    {
      this.required = required;
      return this;
    }

    public Builder title(final TitleResponse title)
    {
      this.title = title;
      return this;
    }

    public Builder img(final ImageResponse img)
    {
      this.img = img;
      return this;
    }

    public Builder video(final VideoResponse video)
    {
      this.video = video;
      return this;
    }

    public Builder data(final DataResponse data)
    {
      this.data = data;
      return this;
    }

    public Builder link(final Link link)
    {
      this.link = link;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public AssetResponse build()
    {
      return new AssetResponse(
          id,
          required,
          title,
          img,
          video,
          data,
          link,
          ext
      );
    }
  }

}
