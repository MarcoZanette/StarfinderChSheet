package com.example.hojadepersonaje.characterdata

open class Item(override var name:String): CharacterProperty() {
    override var description: String=""
    var actions=mutableListOf<Action>()
    var bulk:String=""
    var hands=0
    var level=0
    var traits=mutableListOf<Trait>()
}

class Weapon(name:String):Item(name){
    var damage=""
    var range=0
    var reload=0
    var magazine=0
    var expend=0
    var upgrades=mutableListOf<Upgrade>()
    var group=""
    var category=""
}