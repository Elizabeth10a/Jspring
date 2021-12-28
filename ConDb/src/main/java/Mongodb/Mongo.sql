db
db.version()
db.dropDatabase()
show dbs

use ruby
db.collection.drop()

db.ruby.insert({"name": "珍珍", "age": "18", "sex": "female"})


db.createCollection();
db.createCollection("runoob")
    {"ok": 1}


db.col.insert(
    {
        title: 'MongoDB 教程',
        description: 'MongoDB 是一个 Nosql 数据库',
        by: 'w3cschool',
        url: 'http://www.w3cschool.cn',
        tags: ['mongodb', 'database', 'NoSQL'],
        likes: 100
    })