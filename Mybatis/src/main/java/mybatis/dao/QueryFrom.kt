package mybatis.dao

class QueryFrom {
    var name: String = ""
    var pwd: String = ""

    constructor()
    constructor(name: String, pwd: String) : this() {
        this.pwd = pwd
        this.name = name

    }


}
