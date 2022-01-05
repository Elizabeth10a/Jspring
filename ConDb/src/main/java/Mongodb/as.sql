// 3.2.1 选择和创建数据库
// 选择和创建数据库的语法格式：     如果数据库不存在则自动创建
use test
use ruby
// 查看有权限查看的所有的数据库命令

show dbs
// 或
show databases

/*注意: 在 MongoDB 中，集合只有在内容插入后才会创建! 就是说，创建集合(数据表)后要再插入一个文档(记录)，集合才会真正创建。
 在这之前 存储在内存，需要创建文档才能被 持久话
 */
// 查看当前正在使用的数据库命令
db


/*
MongoDB 中默认的数据库为 test，如果你没有选择数据库，集合将存放在 test 数据库中。
    数据库名可以是满足以下条件的任意UTF-8字符串。
        不能是空字符串（"")。
        不得含有' '（空格)、.、$、/、\和\0 (空字符)。
        应全部小写。
        最多64字节。
有一些数据库名是保留的，可以直接访问这些有特殊作用的数据库。
        admin： 从权限的角度来看，这是"root"数据库。要是将一个用户添加到这个数据库，这个用户自动继承所有数据库的权限
            一些特定的服务器端命令也只能从这个数据库运行，比如列出所有的数据库或者关闭服务器。
        local: 这个数据永远不会被复制，可以用来存储限于本地单台服务器的任意集合
        config: 当Mongo用于分片设置时，config数据库在内部使用，用于保存分片的相关信息。
*/


// 3.2.2 数据库的删除
db.dropDatabase() //主要用来删除已经持久化的数据库

// 集合操作 （表）

/*
* 集合的命名规范：
    集合名不能是空字符串""。
    集合名不能含有\0字符（空字符)，这个字符表示集合名的结尾。
    集合名不能以"system."开头，这是为系统集合保留的前缀。
    用户创建的集合名字不能含有保留字符。有些驱动程序的确支持在集合名里面包含，这是因为某些系统生成的集合中包含该字符。除
    非你要访问这种系统创建的集合，否则千万不要在名字里出现$。
* */
// 显式创建
db.createCollection(name) //name: 要创建的集合名称，
db.createCollection("mycollection")

//查看当前库中的表
show collections
show tables


/*
集合的隐式创建
当向一个集合中插入一个文档的时候，如果集合不存在，则会自动创建集合。*/

db.collection.drop()
db.mycollection.drop()
/*如果成功删除选定集合，则 drop() 方法返回 true，否则返回 false。*/


/*文档基本CRUD*/


/*
db.collection.insert(
    <document or array of documents>,
    {
        writeConcern: <document>,
        ordered: <boolean>
    }
)*/

db.info.drop()
db.info.insert({
    //没有指定 _id ，会自动生成主键值
    _id: 2,
    "articleid": "100000",
    "content": "今天天气真好，阳光明媚",
    "userid": "1001", //默认情是double，要存整型，必须使用函数NumberInt(整型数字)，
    "nickname": "Rose",
    "createdatetime": new Date(),
    "likenum": NumberInt(10),

    // 如果某字段没值，可以赋值为null，或不写该字段。
    "state": null
})
db.info.insertOne({
    _id: 5,
    "articleid": "100000",
    "content": "今天天气真好，阳光明媚",
    "userid": "1001", //默认情是double，要存整型，必须使用函数NumberInt(整型数字)，
    "nickname": "Rose",
    "createdatetime": new Date(),
    "likenum": NumberInt(10),

    // 如果某字段没值，可以赋值为null，或不写该字段。
    "state": null
})
//插入成功提示 WriteResult({ "nInserted" : 1 })

/*
* 注意：
    1. 文档中的键/值对是有序的。
    2. 文档中的值不仅可以是在双引号里面的字符串，还可以是其他几种数据类型（甚至可以是整个嵌入的文档)。
    3. MongoDB区分类型和大小写。
    4. MongoDB的文档不能有重复的键。
    5. 文档的键是字符串。除了少数例外情况，键可以使用任意UTF-8字符。
文档键命名规范：
    键不能含有\0 (空字符)。这个字符用来表示键的结尾。
    .和$有特别的意义，只有在特定环境下才能使用。
    以下划线"_"开头的键是保留的(不是严格要求的)。
*
* */
/*
批量插入
db.collection.insertMany(
[ <document 1> , <document 2>, ... ],
    {
        writeConcern: <document>,
        ordered: <boolean> 指定Mongod实例应执行有序插入还是无序插入。默认为true。
    }
)
如果某条数据插入失败，将会终止插入，但已经插入成功的数据不会回滚掉。
可以使用try catch进行异常捕捉处理，测试的时候可以不处理。
*/
db.info.drop()
try {

    db.info.insertMany([
        {
            "_id": "1", "articleid": "100001",
            "content": "我们不应该把清晨浪费在手机上，健康很重要，一杯温水幸福你我他。",
            "userid": "1001",
            "nickname": "江湖",
            "createdatetime": new Date("2019-08-05T22:08:15.522Z"),
            "likenum": NumberInt(1000),
            "state": "1"
        },
        {
            "_id": "2", "articleid": "100001",
            "content": "我们不应该机上，健康很重要，一杯温水幸福你我他。",
            "userid": "1002",
            "nickname": "于江湖",
            "createdatetime": new Date("2019-08-05T22:08:15.522Z"),
            "likenum": NumberInt(1000),
            "state": "2"
        }, {
            "_id": "3", "articleid": "100001",
            "content": "我们不应该把清晨你我他。",
            "userid": "1003",
            "nickname": "相忘",
            "createdatetime": new Date("2019-08-05T22:08:15.522Z"),
            "likenum": NumberInt(1000),
            "state": "3"
        }, {
            "_id": "4", "articleid": "100001",
            "content": "我们不应该把清晨你我他。",
            "userid": "1003",
            "nickname": "相忘",
            "createdatetime": new Date("2019-08-05T22:08:15.522Z"),
            "likenum": NumberInt(1000),
            "state": "4"
        },
    ]);
} catch (e) {
    print(e)
}


/* 文档的基本查询
db.collection.find(<query>, [projection])

Parameter Type Description
    query document 可选。使用查询运算符指定选择筛选器。若要返回集合中的所有文档，请省略此参数或传递空文档( {} )。
    projection document 可选。指定要在与查询筛选器匹配的文档中返回的字段（投影）。若要返回匹配文档中的所有字段，
请省略此参数。
*/

/*查询所有*/

db.info.find()
db.info.find({})

/*简单条件查询*/
db.info.find({userid: '1001'})
db.info.find({userid: '1003'})
db.info.find({state: '1'})
db.info.find({state: '2'})
db.info.find({_id: "1"})

db.info.find({userid: '1003'})

/*符合条件的第一个*/
db.comment.findOne({userid: '1003'})


/*如果要查询结果返回部分字段，则需要使用投影查询（不显示所有字段，只显示指定的字段）m默认 _id 会显示。。*/

db.info.find({userid: "1003"}, {userid: 1, nickname: '相忘'})

db.info.find({userid: "1003"}, {userid: 1, nickname: 1, _id: 0})
/*
更新文档的语法：
db.collection.update(query, update, options)
//或
db.collection.update(
    <query>,
    <update>,
    {
        upsert: <boolean>,
        multi: <boolean>,
        writeConcern: <document>,
        collation: <document>,
        arrayFilters: [ <filterdocument1>, ... ],
        hint: <document|string> // Available starting in MongoDB 4.2
    }
)


*/

db.info.find({userid: "1001"})

// 覆盖的修改 如果我们想修改_id为1的记
db.info.updateOne({_id: "1"}, {likenum: NumberInt(889)})

use ruby
db.info.updateOne({_id: "1"}, {likenum: NumberInt(1001)})

// 局部修改
db.info.updateOne({_id: "2"}, {"$set": {likenum: NumberInt(889)}})
db.getCollection("info").updateOne({_id: "1"}, {"$set": {likenum: new NumberInt("123")}})
// 批量的修改 更新所有用户为 1003 的用户的昵称为 凯撒大帝 。
db.info.updateOne({_id: "1"}, {"$set": {nickname: "YY"}})
db.info.updateOne({_id: "1"}, {$set: {nickname: "AA"}})


//默认只修改第一条数据
db.info.updateOne({userid: '1003'}, {$set: {nickname: "凯撒2"}})
//修改所有符合条件的数据
db.info.updateOne({userid: "1003"}, {$set: {nickname: "凯撒大帝"}}, {multi: true})


// 列值增长的修改
db.comment.update({_id: '3'}, {$inc: {likenum: NumberInt(1)}})


// 4 删除文档
/*
删除文档的语法结构：
    db.集合名称.remove(条件)

以下语句可以将数据全部删除，请慎用
    db.info.remove({})

*/

// 如果删除_id=1的记录，输入以下语句
db.info.deleteOne({userid:'1003'})
