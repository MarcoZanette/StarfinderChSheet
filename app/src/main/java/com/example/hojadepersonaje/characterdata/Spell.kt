package com.example.hojadepersonaje.characterdata

class Spell(var name:String) {
    var description=""
    var traditions=mutableListOf<String>()
    var range=0
    var area=""
    var defense=""
    var success=""
    var fail=""
    var cSuccess=""
    var cFail=""
    var heightened=mutableListOf<String>()
    var traits=mutableListOf<Trait>()
    var type=""
}