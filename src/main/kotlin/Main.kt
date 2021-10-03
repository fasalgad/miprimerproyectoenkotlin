//Declare values of the answers
const val AFFIRMATIVE_ANSWER = "✅"
const val NEGATIVE_ANSWER = "❌"
const val DOUBTFUL_ANSWER = "?"

//Join the answers with their values
val answers = mapOf(
    "Yes" to AFFIRMATIVE_ANSWER,
    "It's true" to AFFIRMATIVE_ANSWER,
    "Totally" to AFFIRMATIVE_ANSWER,
    "Undoubtedly" to AFFIRMATIVE_ANSWER,
    "Ask in an other moment" to DOUBTFUL_ANSWER,
    "I can't say you in this moment" to DOUBTFUL_ANSWER,
    "Maybe yes, or maybe not" to DOUBTFUL_ANSWER,
    "It's not going to happen" to NEGATIVE_ANSWER,
    "Do not count on it" to NEGATIVE_ANSWER,
    "Definitely not" to NEGATIVE_ANSWER,
    "I don't believe it" to NEGATIVE_ANSWER
)


fun main(args: Array<String>) {
    //Declare the main menu
    println("Hello, I'm the Kotlin 8 Ball. What do you want to do?\n" +
            "1. Ask a question\n" +
            "2. Check all answers\n" +
            "3. Exit")
    //Read the answer of the user
    val inputValue = readLine()


    //functions an executed, by answer of the user
    when(inputValue){
        "1"->askQuestion()
        "2"->checkAnswer()
        "3"->exit()
        else->showError()
    }
}

fun showError() {
    println("Option not valid")
}

fun exit() {
    println("See you later")
}

fun askQuestion(){
    println("What do you want to ask?")
    readLine()
    println("very interesting question .... the answer is :")
    val answerGenerate =answers.keys.random()
    println(answerGenerate)
}
fun checkAnswer(){
    println("Choose one option")
    println("1.- Review all answer")
    println("2.- Review only affirmative answers")
    println("3.- Review only negative answers ")
    println("4.- Review only doubtful answers ")

    val optionRead= readLine()
    when (optionRead){
        "1"->showAnswerByType()
        "2"->showAnswerByType(typeAnswer=AFFIRMATIVE_ANSWER)
        "3"->showAnswerByType(typeAnswer=NEGATIVE_ANSWER)
        "4"->showAnswerByType(typeAnswer=DOUBTFUL_ANSWER)
        else -> println("Option not valid")
    }
}

fun showAnswerByType(typeAnswer: String ="TODOS") {
    val functionAnswer:(Map<String,String>)->Unit={
        answer ->println(answer.keys)
    }
    val filterAnswerValues:(Map<String,String>, String)->Map<String,String> = { map: Map<String, String>, filter: String -> map.filterValues{ values -> values == filter } }
    val showAnswerFilter:(Map<String,String>, String)->Unit ={
        map: Map<String, String>, filter: String->filterAnswerValues(map,filter).also(functionAnswer)
    }
    when(typeAnswer) {
        "TODOS" -> answers.keys.forEach { answer -> println(answer) }
        AFFIRMATIVE_ANSWER,NEGATIVE_ANSWER,DOUBTFUL_ANSWER -> showAnswerFilter(answers,typeAnswer)
        else-> println("Alternative not valid")
    }
}