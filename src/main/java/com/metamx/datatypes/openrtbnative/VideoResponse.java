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
public class VideoResponse
{
  private final String vasttag;

  public VideoResponse(
      @JsonProperty("vasttag") String vasttag
  )
  {
    this.vasttag = vasttag;
  }

  @JsonProperty
  public String getVasttag()
  {
    return vasttag;
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public static class Builder
  {
    private String vasttag;

    public Builder() {}

    public Builder vasttag(final String vasttag)
    {
      this.vasttag = vasttag;
      return this;
    }

    public VideoResponse build()
    {
      return new VideoResponse(
          vasttag
      );
    }
  }
}
