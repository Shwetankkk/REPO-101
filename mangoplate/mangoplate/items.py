# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy


class MangoplateItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    hotel_name = scrapy.Field()
    hotel_category = scrapy.Field()
    hotel_rating = scrapy.Field()
    
