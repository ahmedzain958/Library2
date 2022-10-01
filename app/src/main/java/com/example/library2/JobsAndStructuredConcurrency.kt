package com.example.library2

import kotlinx.coroutines.*

fun main() {
    /*
    * every line     //------------------------------------------------------ represents a topic
    * */
    //------------------------------------------------------
    //the next all between curly braces is called coroutine builder
    GlobalScope.launch {//parent job: if cancelled all the children will be cancelled
        launch { launch { }/*child of child1*/ }//child 1 job : both launch are coroutines not suspend functions
        // thus 2 parallel launch coroutines builders executed in parallel/asynchronously counter-wise 2 parallel suspend fns
        // executed synchronously
        launch { }//child 2 job : both launch are coroutines not suspend functions
    }
    //Note: if any child failed all, the Parent job will be cancelled - beside parent job will not be completed until all the
    //children are completed
    //------------------------------------------------------
    /*Structured Concurrency: relationships between coroutines in-which one depends on the other and another one
    is a child of the other, and one can't work until the other completes
    ma2bad w no2at bedaya w no2at nehaya w de ma te9lash 2abl d- w de mo3tameda 3la d
    w d if cancelled all before will be cancelled as well*/
    //------------------------------------------------------
    //job cancellation method 1
    val job1: Job = GlobalScope.launch {
        launch { getUserFromNetwork() }
        launch { getUserFromDB() }
    }
    //if we called job.cancel() it will cancel all the children jobs beside if any child failed, it will fail the other child
    job1.cancel()
    //------------------------------------------------------
    //job cancellation method 2
    val parentJob : Job = Job()
    //then I will make childToParent child to the parentJob
    val childToParent: Job = GlobalScope.launch(parentJob) {
        launch { getUserFromNetwork() }//child to the childToParent which is child to parentJob
        launch { getUserFromDB() }//child to the childToParent which is child to parentJob
    }
    parentJob.cancel()// cancels childToParent and its children
    //------------------------------------------------------
    //ex: I want to make a delay after 2 children finished
    val parentJob1 : Job = Job()
    //then I will make childToParent child to the parentJob
    val childToParent1: Job = GlobalScope.launch(parentJob1) {
       val child1 =  launch { getUserFromNetwork() }//child to the childToParent which is child to parentJob
       val child2 = launch { getUserFromDB() }//child to the childToParent which is child to parentJob
        child1.join()// makes a suspend to the thread until the joined job finished
        //till now the next line launch{ delay(2000)} won't be executed until child1 only is finished
       launch{ delay(2000)} // in order to make this happen after child1 and child2 execution, use join()
    }
    //------------------------------------------------------
    //ex: I want to make a delay after 2 children finished
    val parentJob2 : Job = Job()
    //then I will make childToParent child to the parentJob
    val childToParent2: Job = GlobalScope.launch(parentJob2) {
        val child1 =  launch { getUserFromNetwork() }//child to the childToParent which is child to parentJob
        val child2 = launch { getUserFromDB() }//child to the childToParent which is child to parentJob
        child1.join()// makes a suspend to the thread until the joined job (child1) finished
        child2.join()// makes a suspend to the thread until the joined job (child2) finished
        //till now the next line launch{ delay(2000)} won't be executed until child1 and child2 are finished
        //child1.join(), child2.join() = joinAll(child1, child2)
        //child1.cancelAndJoin() when job1 finished, it cancels it
        launch{ delay(2000)} // in order to make this happen after child1 and child2 execution, use join()
    }
    //dont forget at the end to call
    parentJob2.cancel()
    //------------------------------------------------------
    val parentJob3 : Job = Job()
    val coroutinesScope:CoroutineScope = CoroutineScope(Dispatchers.IO + parentJob3)
    coroutinesScope.launch {
        val child1 =  launch { getUserFromNetwork() }//child to the childToParent which is child to parentJob
        val child2 = launch { getUserFromDB() }//child to the childToParent which is child to parentJob
        child1.join()// makes a suspend to the thread until the joined job (child1) finished
        child2.join()// makes a suspend to the thread until the joined job (child2) finished
        //till now the next line launch{ delay(2000)} won't be executed until child1 and child2 are finished
        //child1.join(), child2.join() = joinAll(child1, child2)
        //child1.cancelAndJoin() when job1 finished, it cancels it
        launch{ delay(2000)} // in order to make this happen after child1 and child2 execution, use join()
    }

}

private suspend fun getUserFromDB(): String {
    delay(1000)
    return "Aly"
}

private suspend fun getUserFromNetwork(): String {
    delay(2000)
    return "Aly"
}
