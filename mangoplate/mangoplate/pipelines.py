# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter
import mysql.connector


class MangoplatePipeline:

    def create_connection(self):
    # creates connection with the database(host_name,user_name,password,database_name)
        mydb = mysql.connector.connect(
        host = 'localhost',
        user = 'root',
        passwd = '',
        database = 'mangoplate_scrape')  
        
        mycursor = mydb.cursor()
        
        return mydb,mycursor


    def insert_data(self,item):
        
        hotel_name = item['hotel_name']
        hotel_category = item['hotel_category']
        hotel_rating = item['hotel_rating']

        try:
            mydb,mycursor = self.create_connection()
            #insert_sql = "insert into mangoplate_data(hotel_name,hotel_category,hotel_rating) values ('%s,%s,%s')"
            
            mycursor.execute("INSERT INTO mangoplate_data VALUES (%s,%s,%s)",(hotel_name,hotel_category,hotel_rating))
            mydb.commit()
        except Exception as e:
            print("Some exception occured in fetching data from databse {}".format(e))
        finally:
            try:
                mydb.close()
                mycursor.close()
            except Exception as e:
                print("Database connection already closed.")

    def process_item(self, item, spider):
        print("++++++++++++++++++++++++++++++++ i am in pipelines.py ++++++++++++++++++++++++++++++++++++++++++++++")
        print(item)
        self.insert_data(item)    
        print("+++++++++++++++++++++++++++++++++++ out now +++++++++++++++++++++++++++++++++++++++++++++++++++++++")
