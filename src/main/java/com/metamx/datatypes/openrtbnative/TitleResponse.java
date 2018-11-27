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

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TitleResponse
{
  private final String text;
  private final Ext ext;

  public TitleResponse(
      @JsonProperty("text") String text,
      @JsonProperty("ext") Ext ext
  )
  {
    this.text = text;
    this.ext = ext;
  }

  @JsonProperty
  public String getText()
  {
    return text;
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
    private String text;
    private Ext ext;

    public Builder() {}

    public Builder text(final String text)
    {
      this.text = text;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public TitleResponse build()
    {
      return new TitleResponse(text, ext);
    }
  }
}
