package com.rosariobagaskara.quizapp

object Constants {
    fun getQuestion(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            R.drawable.indonesia_flag,
            "What country flag is this?",
            "Indonesia",
            "Malaysia",
            "Singapore",
            "Thailand",
            1
        )

        questionsList.add(que1)

        val que2 = Question(
            2,
            R.drawable.argentina_flag,
            "What country flag is this?",
            "Argentina",
            "Brazil",
            "Mexico",
            "Chile",
            1
        )

        questionsList.add(que2)

        val que3 = Question(
            3,
            R.drawable.indonesia_flag,
            "What country flag is this?",
            "Indonesia",
            "Malaysia",
            "Singapore",
            "Thailand",
            1
        )

        questionsList.add(que3)

        val que4 = Question(
            4,
            R.drawable.canada_flag,
            "What country flag is this?",
            "USA",
            "Canada",
            "Russia",
            "Portugal",
            2
        )

        questionsList.add(que4)

        val que5 = Question(
            5,
            R.drawable.china_flag,
            "What country flag is this?",
            "Mongolia",
            "North Korea",
            "China",
            "Indonesia",
            3
        )

        questionsList.add(que5)

        val que6 = Question(
            6,
            R.drawable.japan_flag,
            "What country flag is this?",
            "South Korea",
            "Japan",
            "Taiwan",
            "Malaysia",
            2
        )

        questionsList.add(que6)

        val que7 = Question(
            7,
            R.drawable.malaysia_flag,
            "What country flag is this?",
            "Malaysia",
            "USA",
            "Papua New Guinea",
            "Thailand",
            1
        )

        questionsList.add(que7)

        val que8 = Question(
            8,
            R.drawable.portugal_flag,
            "What country flag is this?",
            "Spain",
            "Greece",
            "Sweden",
            "Portugal",
            4
        )

        questionsList.add(que8)

        val que9 = Question(
            9,
            R.drawable.singapore_flag,
            "What country flag is this?",
            "Indonesia",
            "Malaysia",
            "Singapore",
            "Thailand",
            3
        )

        questionsList.add(que9)

        val que10 = Question(
            10,
            R.drawable.usa_flag,
            "What country flag is this?",
            "Canada",
            "Malaysia",
            "United Kingdom",
            "USA",
            4
        )

        questionsList.add(que10)

        return questionsList
    }
}