package mybatis.module


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/21/21
 * @Software: IntelliJ IDEA
 */
class User {
    var id: Int = 0
    var name: String = ""
    var pwd: String = ""

    constructor()
    constructor(id: Int, name: String) : this() {
        this.id = id
        this.name = name

    }

    constructor(id: Int, name: String, pwd: String) : this(id, name) {
        this.id = id
        this.name = name
        this.pwd = pwd
    }

    override fun toString(): String {
        return "UserDao(id=$id, name='$name', pwd='$pwd')"
    }


}