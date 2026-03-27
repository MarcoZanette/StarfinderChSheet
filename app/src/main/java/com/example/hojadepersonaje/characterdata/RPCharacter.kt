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
    var resistances=emptyList<String>()
    var inmunities=emptyList<String>()
    var skills= emptyMap<String,Int>()
    var skillProficiencies=emptyMap<String,Int>()
    var languages=emptyList<String>()
    var perception=0
    var speed=0
    var strikes=emptyList<Weapon>()
    var weaponProficiencies=emptyMap<String,Int>()
    var feats=emptyList<Feat>()
    var inventory=emptyList<Item>()
    var actionList=emptyList<Action>()
    var magicalTradition=""
    var spellsPerDay=emptyList<Int>()//list ya que cada nivel de spell tiene un slot especifico (0 cantrip, 1 lv1, 2 lv2, etc)
    val spells=emptyList<Spell>()
    val spellAttack=0
    val spellProficiency=0

}