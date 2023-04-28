# Ammattikissat


This is a rudimentary cat battling game. It includes features such as training and battling. 

## About

Clone the library and emulate in android studio and see how it does not work.

### Prerequisites

Latest version of Android studio and android 11 / API 30 are required

### Demo

There will be a demo video here: //to-do

## Usage

This is strictly for entertainment. Only enjoy the product.

## To-Do

- finalize project
- demo video

## License

MIT License Copyright (c) [2023] [Kolmen Hengen Tyhmä]

## Legal

Project artwork created using Hotpot.ai

## Game mechanics
### Tuuri
Pelissä on luck/tuuri/onni. Tämä esiintyy sillä, että hyökätessä todennäköisyys kriittiseen osumaan (2 extra hyökkäys pistettä kyseiseen hyökkäykseen) lasketatan onnesta kaavalla: random.nextInt(10)+luck > 6 .Siten siis todennäköisyys on 33% + tuurin aiheuttama painotus

### Vahingonotto 
Pelissä vahingonotto noudattaa seuraavaa kaavaa damage = AttackDamage-(DefencePower/2)

## Alpha 0.2.0 Cats:

### Töikissa (Raksa):
- 20 hp
- 4 atk
- 6 def
- 1 lck
Ability:
- Terveytä maksimissaan 4 elämäpistettä.
- 
### Putkissa (LVI-kissa):
- 24 hp
- 6 atk
- 8 def
- 0 lck
Ability:
- Vaihda yksi attack piste yhteen defenceen

### Logiskiskiskistiikka (Logistiikka): high skill low stat
- 14 hp
- 3 atk
- 4 def
- 2 lck
Ability:
- 2 extra hyökkäys pistettä seuraavaksi kahdeksi vuoroksi

### Sähkökisse (Sähkö)
- 20 hp
- 5 atk
- 2 def
- 1 lck
Ability:
- Kasvata hyökkäystä viidellä pisteellä, viiden elämäpisteen kustannuksella

### Autokissa (Auto)
- 18 hp
- 8 atk
- 4 def
- 0 lck
Ability:
- Kasvata tuuria kolmella yhden vuoron ajaksi

![meme](kissa.png)

![UML Classdiagram](luokkakaavio.png)
