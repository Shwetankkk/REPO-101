import scrapy
from ..items import MangoplateItem


class MangplateSpider(scrapy.Spider):
    name = 'mangoplate'
    allowed_domains = ['www.mangoplate.com/en/search/seoul%20restaurants?keyword=seoul%20restaurants&page=1']
    start_urls = ['https://www.mangoplate.com/en/search/seoul%20restaurants?keyword=seoul%20restaurants&page=1/']

    def parse(self, response):
        item = MangoplateItem()
        cards = response.css('.list-restaurant')

        for card in cards:
            hotel_name =  card.css('.restaurant-item .title::text').extract_first()
            hotel_category = card.css('.etc::text').extract_first()
            hotel_rating = card.css('.search_point::text').extract_first()

            item['hotel_name'] = hotel_name
            item['hotel_category'] = hotel_category
            item['hotel_rating'] = hotel_rating

            yield item
