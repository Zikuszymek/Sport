package com.mobile.ziku.sport.models

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "rss")
data class NewsResponse(
        @field:Attribute(name = "version") var version: String? = null,
        @field:Element(name = "channel") var channel: Channel? = null
)

data class Channel(
        @field:Element(name = "title") var title: String? = null,
        @field:Element(name = "description", required = false) var description: String? = null,
        @field:Element(name = "language") var language: String? = null,
        @field:Element(name = "pubDate") var pubDate: String? = null,
        @field:Element(name = "link") var link: String? = null,
        @field:ElementList(entry = "category", inline = true) var category: ArrayList<String>? = null,
        @field:ElementList(name = "item", inline = true) var items: ArrayList<Item>? = null
)

data class Item(
        @field:Element(name = "guid") var guid: String? = null,
        @field:Element(name = "title") var title: String? = null,
        @field:Element(name = "pubDate") var pubDate: String? = null,
        @field:Element(name = "enclosure") var enclosure: Enclosure? = null,
        @field:Element(name = "description") var description: String? = null,
        @field:Element(name = "link") var link: String? = null,
        @field:Element(name = "category") var category: String? = null
)

data class Enclosure(
        @field:Attribute(name = "length") var length: String? = null,
        @field:Attribute(name = "url") var url: String? = null,
        @field:Attribute(name = "type") var type: String? = null

)
