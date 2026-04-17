package com.example.hojadepersonaje.characterdata

class RPCharacter(var id:Int,var name:String ) {
    var level=0
    var ancestry=""
    var heritage=""
    var size=""
    var background=""
    var rpClass=""
    var attributes=MutableList<Int>(6){
        0
    }
    var ac=0
    var shield=0
    var armorProficiency=0
    var fortitude=0
    var reflex=0
    var will=0
    var maxHp=0
    var resistances=mutableListOf<String>("")
    var inmunities=mutableListOf<String>("")
    var skills= mutableMapOf<String,Int>(Pair("",0))
    var skillProficiencies=mutableMapOf<String,Int>()
    var languages=mutableListOf<String>()
    var perception=0
    var speed=0
    var strikes=mutableListOf<Weapon>(Weapon(""))
    var weaponProficiencies=mutableMapOf<String,Int>()
    var feats=mutableListOf<Feat>()
    var inventory=mutableListOf<Item>(Item(""))
    var actionList=mutableListOf<Action>(Action("",0))
    var magicalTradition=""
    var spellsPerDay=mutableListOf<Int>()//list ya que cada nivel de spell tiene un slot especifico (0 cantrip, 1 lv1, 2 lv2, etc)
    val spells=mutableListOf<Spell>(Spell(""))
    val spellAttack=0
    val spellProficiency=0

}