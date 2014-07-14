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

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class App
{
  private final String id;
  private final String name;
  private final String domain;
  private final List<String> cat;
  private final List<String> sectionCat;
  private final List<String> pageCat;
  private final String ver;
  private final String bundle;
  private final Integer privacyPolicy;
  private final Integer paid;
  private final Publisher publisher;
  private final Content content;
  private final String keywords;
  private final String storeUrl;
  private final Ext ext;

  public App(
      @JsonProperty("id") String id,
      @JsonProperty("name") String name,
      @JsonProperty("domain") String domain,
      @JsonProperty("cat") List<String> cat,
      @JsonProperty("sectioncat") List<String> sectionCat,
      @JsonProperty("pagecat") List<String> pageCat,
      @JsonProperty("ver") String ver,
      @JsonProperty("bundle") String bundle,
      @JsonProperty("privacypolicy") Integer privacyPolicy,
      @JsonProperty("paid") Integer paid,
      @JsonProperty("publisher") Publisher publisher,
      @JsonProperty("content") Content content,
      @JsonProperty("keywords") String keywords,
      @JsonProperty("storeurl") String storeUrl,
      @JsonProperty("ext") Ext ext
  )
  {
    this.id = id;
    this.name = name;
    this.domain = domain;
    this.cat = cat;
    this.sectionCat = sectionCat;
    this.pageCat = pageCat;
    this.ver = ver;
    this.bundle = bundle;
    this.privacyPolicy = privacyPolicy;
    this.paid = paid;
    this.publisher = publisher;
    this.content = content;
    this.keywords = keywords;
    this.storeUrl = storeUrl;
    this.ext = ext;
  }

  @JsonProperty
  public String getId()
  {
    return id;
  }

  @JsonProperty
  public String getName()
  {
    return name;
  }

  @JsonProperty
  public String getDomain()
  {
    return domain;
  }

  @JsonProperty
  public List<String> getCat()
  {
    return cat;
  }

  @JsonProperty("sectioncat")
  public List<String> getSectionCat()
  {
    return sectionCat;
  }

  @JsonProperty("pagecat")
  public List<String> getPageCat()
  {
    return pageCat;
  }

  @JsonProperty
  public String getVer()
  {
    return ver;
  }

  @JsonProperty
  public String getBundle()
  {
    return bundle;
  }

  @JsonProperty("privacypolicy")
  public Integer getPrivacyPolicy()
  {
    return privacyPolicy;
  }

  @JsonProperty
  public Integer getPaid()
  {
    return paid;
  }

  @JsonProperty
  public Publisher getPublisher()
  {
    return publisher;
  }

  @JsonProperty
  public Content getContent()
  {
    return content;
  }

  @JsonProperty
  public String getKeywords()
  {
    return keywords;
  }

  @JsonProperty("storeurl")
  public String getStoreUrl()
  {
    return storeUrl;
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
    private String id;
    private String name;
    private String domain;
    private List<String> cat;
    private List<String> sectionCat;
    private List<String> pageCat;
    private String ver;
    private String bundle;
    private Integer privacyPolicy;
    private Integer paid;
    private Publisher publisher;
    private Content content;
    private String keywords;
    private String storeUrl;
    private Ext ext;

    public Builder() {}

    public Builder id(final String id)
    {
      this.id = id;
      return this;
    }

    public Builder name(final String name)
    {
      this.name = name;
      return this;
    }

    public Builder domain(final String domain)
    {
      this.domain = domain;
      return this;
    }

    public Builder cat(final List<String> cat)
    {
      this.cat = cat;
      return this;
    }

    public Builder sectionCat(final List<String> sectionCat)
    {
      this.sectionCat = sectionCat;
      return this;
    }

    public Builder pageCat(final List<String> pageCat)
    {
      this.pageCat = pageCat;
      return this;
    }

    public Builder ver(final String ver)
    {
      this.ver = ver;
      return this;
    }

    public Builder bundle(final String bundle)
    {
      this.bundle = bundle;
      return this;
    }

    public Builder privacyPolicy(final Integer privacyPolicy)
    {
      this.privacyPolicy = privacyPolicy;
      return this;
    }

    public Builder paid(final Integer paid)
    {
      this.paid = paid;
      return this;
    }

    public Builder publisher(final Publisher publisher)
    {
      this.publisher = publisher;
      return this;
    }

    public Builder content(final Content content)
    {
      this.content = content;
      return this;
    }

    public Builder keywords(final String keywords)
    {
      this.keywords = keywords;
      return this;
    }

    public Builder storeUrl(final String storeUrl)
    {
      this.storeUrl = storeUrl;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public App build()
    {
      return new App(
          id,
          name,
          domain,
          cat,
          sectionCat,
          pageCat,
          ver,
          bundle,
          privacyPolicy,
          paid,
          publisher,
          content,
          keywords,
          storeUrl,
          ext
      );
    }
  }
}
