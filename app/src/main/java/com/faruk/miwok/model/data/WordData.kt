package com.faruk.miwok.model.data

import com.faruk.miwok.R

object WordData {

    private val wordList = listOf(
        // Numbers
        Word("one", "lutti", R.drawable.number_one, "Numbers", "number_one"),
        Word("two", "oṭiiko", R.drawable.number_two, "Numbers", "number_two"),
        Word("three", "tolookosu", R.drawable.number_three, "Numbers", "number_three"),
        Word("four", "oyyisa", R.drawable.number_four, "Numbers", "number_four"),
        Word("five", "massokka", R.drawable.number_five, "Numbers", "number_five"),
        Word("six", "temmokka", R.drawable.number_six, "Numbers", "number_six"),
        Word("seven", "kenekaku", R.drawable.number_seven, "Numbers", "number_seven"),
        Word("eight", "kawinta", R.drawable.number_eight, "Numbers", "number_eight"),
        Word("nine", "wo’e", R.drawable.number_nine, "Numbers", "number_nine"),
        Word("ten", "na’aacha", R.drawable.number_ten, "Numbers", "number_ten"),

        // Family
        Word("father", "әpә", R.drawable.family_father, "Family", "family_father"),
        Word("mother", "әṭa", R.drawable.family_mother, "Family", "family_mother"),
        Word("son", "angsi", R.drawable.family_son, "Family", "family_son"),
        Word("daughter", "tune", R.drawable.family_daughter, "Family", "family_daughter"),
        Word("older brother", "taachi", R.drawable.family_older_brother, "Family", "family_older_brother"),
        Word("younger brother", "chalitti", R.drawable.family_younger_brother, "Family", "family_younger_brother"),
        Word("older sister", "teṭe", R.drawable.family_older_sister, "Family", "family_older_sister"),
        Word("younger sister", "kolliti", R.drawable.family_younger_sister, "Family", "family_younger_sister"),
        Word("grandmother", "ama", R.drawable.family_grandmother, "Family", "family_grandmother"),
        Word("grandfather", "paapa", R.drawable.family_grandfather, "Family", "family_grandfather"),

        // Colors
        Word("red", "weṭeṭṭi", R.drawable.color_red, "Colors", "color_red"),
        Word("green", "chokokki", R.drawable.color_green, "Colors", "color_green"),
        Word("brown", "ṭakaakki", R.drawable.color_brown, "Colors", "color_brown"),
        Word("gray", "ṭopoppi", R.drawable.color_gray, "Colors", "color_gray"),
        Word("black", "kululli", R.drawable.color_black, "Colors", "color_black"),
        Word("white", "kelelli", R.drawable.color_white, "Colors", "color_white"),
        Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, "Colors", "color_dusty_yellow"),
        Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, "Colors", "color_mustard_yellow"),

        // Phrases
        Word("Where are you going?", "minto wuksus", 0, "Phrases", "phrase_where_are_you_going"),
        Word("What is your name?", "tinnә oyaase'nә", 0, "Phrases", "phrase_what_is_your_name"),
        Word("My name is...", "oyaaset...", 0, "Phrases", "phrase_my_name_is"),
        Word("How are you feeling?", "michәksәs?", 0, "Phrases", "phrase_how_are_you_feeling"),
        Word("I’m feeling good.", "kuchi achit", 0, "Phrases", "phrase_im_feeling_good"),
        Word("Are you coming?", "әәnәs'aa?", 0, "Phrases", "phrase_are_you_coming"),
        Word("Yes, I’m coming.", "hәә’ әәnәm", 0, "Phrases", "phrase_yes_im_coming"),
        Word("I’m coming.", "әәnәm", 0, "Phrases", "phrase_im_coming"),
        Word("Let’s go.", "yoowutis", 0, "Phrases", "phrase_lets_go"),
        Word("Come here.", "әnni'nem", 0, "Phrases", "phrase_come_here")
    )

    fun getAllWords(): List<Word> = wordList
}
