package com.example.hojadepersonaje.characterdata

class Action(override var name:String, var cost:Int): CharacterProperty() {
    override var description:String=""
}

class Trait(override var name:String): CharacterProperty(){
    override var description:String=""
}

class Upgrade(override var name:String): CharacterProperty(){
    override var description:String=""
}

class Feat(override var name:String): CharacterProperty(){
    var requirements=""
    override var description=""
}