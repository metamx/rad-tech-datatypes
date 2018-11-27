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

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Site
{
  private final String id;
  private final String name;
  private final String domain;
  private final List<String> cat;
  private final List<String> sectionCat;
  private final List<String> pageCat;
  private final String page;
  private final Integer privacyPolicy;
  private final String ref;
  private final String search;
  private final Integer mobile;
  private final Publisher publisher;
  private final Content content;
  private final String keywords;
  private final Ext ext;

  public Site(
      @JsonProperty("id") String id,
      @JsonProperty("name") String name,
      @JsonProperty("domain") String domain,
      @JsonProperty("cat") List<String> cat,
      @JsonProperty("sectioncat") List<String> sectionCat,
      @JsonProperty("pagecat") List<String> pageCat,
      @JsonProperty("page") String page,
      @JsonProperty("privacypolicy") Integer privacyPolicy,
      @JsonProperty("ref") String ref,
      @JsonProperty("search") String search,
      @JsonProperty("mobile") Integer mobile,
      @JsonProperty("publisher") Publisher publisher,
      @JsonProperty("content") Content content,
      @JsonProperty("keywords") String keywords,
      @JsonProperty("ext") Ext ext
  )
  {
    this.id = id;
    this.name = name;
    this.domain = domain;
    this.cat = cat;
    this.sectionCat = sectionCat;
    this.pageCat = pageCat;
    this.page = page;
    this.privacyPolicy = privacyPolicy;
    this.ref = ref;
    this.search = search;
    this.mobile = mobile;
    this.publisher = publisher;
    this.content = content;
    this.keywords = keywords;
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
  public String getPage()
  {
    return page;
  }

  @JsonProperty("privacypolicy")
  public Integer getPrivacyPolicy()
  {
    return privacyPolicy;
  }

  @JsonProperty
  public String getRef()
  {
    return ref;
  }

  @JsonProperty
  public String getSearch()
  {
    return search;
  }

  @JsonProperty
  public Integer getMobile()
  {
    return mobile;
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
    private String page;
    private Integer privacyPolicy;
    private String ref;
    private String search;
    private Integer mobile;
    private Publisher publisher;
    private Content content;
    private String keywords;
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

    public Builder page(final String page)
    {
      this.page = page;
      return this;
    }

    public Builder privacyPolicy(final Integer privacyPolicy)
    {
      this.privacyPolicy = privacyPolicy;
      return this;
    }

    public Builder ref(final String ref)
    {
      this.ref = ref;
      return this;
    }

    public Builder search(final String search)
    {
      this.search = search;
      return this;
    }

    public Builder mobile(final Integer mobile)
    {
      this.mobile = mobile;
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

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public Site build()
    {
      return new Site(
          id,
          name,
          domain,
          cat,
          sectionCat,
          pageCat,
          page,
          privacyPolicy,
          ref,
          search,
          mobile,
          publisher,
          content,
          keywords,
          ext
      );
    }
  }
}
